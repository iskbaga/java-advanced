package info.kgeorgiy.ja.bagautdinov.walk;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Set;

class Walker {
    private final int depth;

    public Walker(int depth) {
        this.depth = depth;
    }

    public void walk(String[] args) {
        if (args == null || args.length != 2) {
            System.err.println("Must be only 2 arguments");
            return;
        }
        if (args[0] == null || args[1] == null) {
            System.err.println("Invalid arguments");
            return;
        }

        Path inputPath, outputPath;

        try {
            inputPath = Path.of(args[0]);
        } catch (InvalidPathException e) {
            System.err.println("Problem with input path: " + e.getMessage());
            return;
        }

        try {
            outputPath = Path.of(args[1]);
            if (outputPath.getParent() != null) {
                Files.createDirectories(outputPath.getParent());
            }
        } catch (InvalidPathException e) {
            System.err.println("Problem with output path: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            return;
        }

        try (BufferedReader reader = Files.newBufferedReader(inputPath, StandardCharsets.UTF_8)) {
            try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
                String path;
                MyFileVisitor visitor = new MyFileVisitor(writer);
                while (true) {
                    try {
                        path = reader.readLine();
                        if (path == null) {
                            break;
                        }
                    } catch (IOException e) {
                        System.err.println("Problem when reading new line from " + inputPath + ": " + e);
                        break;
                    }
                    try {
                        Path p = Path.of(path);
                        Files.walkFileTree(p, Set.of(), depth, visitor);
                    } catch (IOException | SecurityException e) {
                        System.err.println("I/O error: " + e.getMessage()); // :NOTE: I/O error
                    } catch (InvalidPathException e) {
                        visitor.writeError(path);
                        System.err.println("Problem with path " + e);
                    }
                }
            } catch (IOException | SecurityException e) {
                System.err.println("Problem with writer " + outputPath + ": " + e);
            } catch (InvalidPathException e) {
                System.err.println("Output file not found " + outputPath + ": " + e);
            }
        } catch (IOException | SecurityException e) {
            System.err.println("Problem with reader " + outputPath + ": " + e);
        } catch (InvalidPathException e) {
            System.err.println("Input file not found " + inputPath + ": " + e);
        }
    }
}
