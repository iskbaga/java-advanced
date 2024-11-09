package info.kgeorgiy.ja.bagautdinov.implementor;

import info.kgeorgiy.java.advanced.implementor.ImplerException;
import info.kgeorgiy.java.advanced.implementor.JarImpler;
import org.junit.jupiter.api.Assertions;

import javax.annotation.processing.Completions;
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.jar.Attributes;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;

public class Implementor implements JarImpler {
    private static final String LINE_SEP = System.lineSeparator();
    private String implName; // :NOTE: сохранение названия класса в поле Implementor не позволяет в двух потоказ выполнять метода implement, что не хорошо

    private static String getClassPath(final Class<?> token) {
        try {
            return Path.of(token.getProtectionDomain().getCodeSource().getLocation().toURI()).toString();
        } catch (final URISyntaxException e) {
            throw new AssertionError(e);
        }
    }

    private static void compile(final Class<?> token, final Path root, final String file) {
        final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        // :NOTE: Assertions доступен только из тестов, при этом ваше решение от junit не зависит
        Assertions.assertNotNull(compiler, "Could not find java compiler, include tools.jar to classpath");
        final String classpath = root + File.pathSeparator + getClassPath(token);
        final String[] args = {file, "-cp", classpath, "-encoding", "UTF8"};
        final int exitCode = compiler.run(null, null, null, args);
        Assertions.assertEquals(0, exitCode, "Compiler exit code");
    }

    @Override
    public void implement(Class<?> token, Path root) throws ImplerException {
        if (isPrivateInterface(token)) {
            throw new ImplerException("You cant implement private interface: " + token.getName());
        }
        // :NOTE: явно это константа.
        final Class<?>[] specialClasses = {java.lang.Record.class, Completions.class, Enum.class};
        // :NOTE: Completions.class это не спциальный класс, просто у него 0 публичных конструкторов, поэтому его невохможно наследоваь
        // :NOTE: такие случаи надо проверять более общим кодов
        if (isSpecialClass(token, specialClasses)) {
            throw new ImplerException("You cant implement special class: " + token.getName());
        }
        if (isInvalidClass(token)) {
            throw new ImplerException("Invalid class");
        }

        implName = token.getSimpleName() + "Impl";
        root = resolvePath(root, token);

        try {
            if (root.getParent() != null) {
                Files.createDirectories(root.getParent());
            }
        } catch (IOException e) {
            throw new ImplerException("Error while creating directories for output", e);
        } catch (SecurityException e) {
            throw new ImplerException("No access to " + root.getFileName());
        }

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(root, StandardCharsets.UTF_8)) {
            if (!token.getPackageName().isEmpty()) {
                bufferedWriter.write(writeHelper("package " + token.getPackageName() + ";" + LINE_SEP));
            }
            String keyword = token.isInterface() ? "implements" : "extends";
            bufferedWriter.write(writeHelper(String.format("public class %s %s %s {%n", implName, keyword, token.getCanonicalName())));
            for (Constructor<?> constructor : token.getDeclaredConstructors()) {
                if (!Modifier.isPrivate(constructor.getModifiers())) {
                    String signature = getSignature(constructor);
                    String exceptions = getExceptions(constructor.getExceptionTypes());
                    String parameters = getParameters(constructor, true);
                    bufferedWriter.write(writeHelper(signature + " " + exceptions + " {" + LINE_SEP));
                    // :NOTE: в этом месте у кода нет оступов, то есть проблема с форматированием
                    bufferedWriter.write(writeHelper("super (" + parameters + ") ;" + LINE_SEP));
                    bufferedWriter.write(writeHelper("  }" + LINE_SEP));
                }
            }

            Map<String, String> methods = new HashMap<>();
            addMethods(methods, token.getMethods());
            for (Class<?> temp = token; temp != null; temp = temp.getSuperclass()) {
                addMethods(methods, token.getDeclaredMethods());
            }
            for (Map.Entry<String, String> entry : methods.entrySet()) {
                bufferedWriter.write(writeHelper(entry.getKey() + " {" + LINE_SEP));
                bufferedWriter.write(writeHelper("return " + entry.getValue() + ";" + LINE_SEP));
                bufferedWriter.write(writeHelper("}" + LINE_SEP));
            }
            bufferedWriter.write(writeHelper("}" + LINE_SEP));

        } catch (IOException e) {
            throw new ImplerException("Error while writing implementation", e);
        }
    }

    private boolean isPrivateInterface(Class<?> token) {
        return token.isInterface() && Modifier.isPrivate(token.getModifiers());
    }

    private boolean isInvalidClass(Class<?> token) {
        return token.isArray()
                || token.isPrimitive()
                || Modifier.isFinal(token.getModifiers());
    }

    private boolean isSpecialClass(Class<?> token, Class<?>[] classes) {
        for (Class<?> x : classes) {
            if (token.equals(x)) {
                return true;
            }
        }
        return false;
    }

    private String getSignature(Executable exec) {
        StringBuilder stringBuilder = new StringBuilder();
        String signatureModifier = Modifier.toString(exec.getModifiers()
                & ~(Modifier.ABSTRACT | Modifier.NATIVE | Modifier.TRANSIENT));
        stringBuilder.append(signatureModifier).append(" ");
        if (exec instanceof Method method) {
            stringBuilder.append(method.getReturnType().getCanonicalName())
                    .append(" ")
                    .append(method.getName());
        } else {
            stringBuilder.append(implName);
        }
        stringBuilder.append("(")
                .append(getParameters(exec, false))
                .append(")");
        return stringBuilder.toString();
    }

    private <T> String mapParameters(T[] params, Function<? super T, String> mapper) {
        return Arrays.stream(params)
                .map(mapper)
                .collect(Collectors.joining(", "));
    }

    private String getParameters(Executable exec, boolean typeWriting) {
        return mapParameters(exec.getParameters(),
                param -> (typeWriting ? "" :
                        param.getType().getCanonicalName()) + " " + param.getName());
    }

    private String getExceptions(Class<?>[] exceptions) {
        if (exceptions.length == 0) {
            return "";
        }
        return "throws " + mapParameters(exceptions, Class::getCanonicalName);
    }

    private void addMethods(Map<String, String> methods, Method[] tokenMethods) {
        Arrays.stream(tokenMethods)
                .filter(method -> Modifier.isAbstract(method.getModifiers()))
                .forEach(method -> {
                    String signature = getSignature(method) + getExceptions(method.getExceptionTypes());
                    methods.put(signature, getReturnValue(method.getReturnType()));
                });
    }

    private String getReturnValue(Class<?> token) {
        if (token.equals(boolean.class)) {
            return "false";
        }
        if (token.equals(void.class)) {
            return "";
        }
        if (token.isPrimitive()) {
            return "0";
        }
        return "null";
    }

    private Path resolvePath(Path root, Class<?> token) {
        return root.resolve((token.getPackageName() + "." + implName)
                .replace(".", File.separator) + ".java");
    }

    @Override
    public void implementJar(Class<?> token, Path jarFile) throws ImplerException {
        Path path;
        try {
            path = Files.createTempDirectory(jarFile.getParent(), "out");
        } catch (IOException e) {
            throw new ImplerException("Error while creating directory", e);
        } catch (SecurityException e) {
            throw new ImplerException("No access to " + jarFile.getFileName());
        }
        implement(token, path);
        compile(token, path,
                resolvePath(path, token).toAbsolutePath().toString());
        makeJar(token, jarFile, path);
    }

    private String writeHelper(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        final char[] characters = str.toCharArray();
        for (final char s : characters) {
            stringBuilder.append(String.format("\\u%04x", (int) s));
        }
        return stringBuilder.toString();
    }

    private void makeJar(Class<?> token, Path jarFile, Path path) throws ImplerException {
        Manifest manifest = new Manifest();
        Attributes attributes = manifest.getMainAttributes();
        attributes.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        attributes.put(Attributes.Name.IMPLEMENTATION_VENDOR, "Bagautdinov Iskander");
        try (JarOutputStream stream = new JarOutputStream(Files.newOutputStream(jarFile), manifest)) {
            final String className = token.getPackageName().replace('.', '/')
                    + "/" + implName + ".class";
            stream.putNextEntry(new ZipEntry(className));
            Files.copy(Paths.get(path.toString(), className), stream);
        } catch (IOException e) {
            throw new ImplerException(e.getMessage());
        }
    }
}
