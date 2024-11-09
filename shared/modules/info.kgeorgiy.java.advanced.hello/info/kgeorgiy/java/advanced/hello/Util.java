package info.kgeorgiy.java.advanced.hello;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;

public final class Util {
    private static final Charset CHARSET;
    private static final String DIGITS_STR;
    private static final Pattern DIGIT;
    private static final Pattern NUMBER;
    private static final List<String> ANSWER;
    private static final List<NumberFormat> FORMATS;
    private static final boolean NUMBERS = true;
    private static BiFunction<String, Random, String> mode;
    private static final List<Function<String, String>> CORRUPTIONS;

    private Util() {
    }

    public static String getString(DatagramPacket packet) {
        return getString(packet.getData(), packet.getOffset(), packet.getLength());
    }

    public static String getString(byte[] data, int offset, int length) {
        return new String(data, offset, length, CHARSET);
    }

    private static void send(DatagramSocket socket, DatagramPacket packet, String request) throws IOException {
        byte[] bytes = getBytes(request);
        packet.setData(bytes);
        packet.setLength(packet.getData().length);
        socket.send(packet);
    }

    public static byte[] getBytes(String string) {
        return string.getBytes(CHARSET);
    }

    public static DatagramPacket createPacket(DatagramSocket socket) throws SocketException {
        return new DatagramPacket(new byte[socket.getReceiveBufferSize()], socket.getReceiveBufferSize());
    }

    public static String request(String string, DatagramSocket socket, SocketAddress address) throws IOException {
        send(socket, string, address);
        return receive(socket);
    }

    public static String receive(DatagramSocket socket) throws IOException {
        DatagramPacket inPacket = createPacket(socket);
        socket.receive(inPacket);
        return getString(inPacket);
    }

    public static void send(DatagramSocket socket, String request, SocketAddress address) throws IOException {
        DatagramPacket outPacket = new DatagramPacket(new byte[0], 0);
        outPacket.setSocketAddress(address);
        send(socket, outPacket, request);
    }

    public static String response(String request) {
        return response(request, "Hello, $");
    }

    public static String response(String request, String format) {
        return format.replaceAll("\\$", request);
    }

    public static Callable<int[]> server(String prefix, int threads, double p, DatagramSocket socket) {
        return () -> {
            int[] expected = new int[threads];
            Random random = new Random(4702347503224875082L + (long)Objects.hash(new Object[]{prefix, threads, p}));

            try {
                while(true) {
                    DatagramPacket packet = createPacket(socket);
                    socket.receive(packet);
                    String request = getString(packet);
                    String message = "Invalid or unexpected request " + request;
                    Assertions.assertTrue(request.startsWith(prefix), message);
                    String[] parts = request.substring(prefix.length()).split("_");
                    Assertions.assertEquals(2, parts.length, message);

                    try {
                        int thread = Integer.parseInt(parts[0]) - 1;
                        int no = Integer.parseInt(parts[1]);
                        Assertions.assertTrue(0 <= thread && thread < expected.length, message);
                        Assertions.assertEquals(expected[thread] + 1, no, message);
                        String response = (String)mode.apply(request, random);
                        if (no != 0 && !(p >= random.nextDouble())) {
                            if (random.nextBoolean()) {
                                send(socket, packet, (String)((Function)select(CORRUPTIONS, random)).apply(response));
                            }
                        } else {
                            int var10002 = expected[thread]++;
                            send(socket, packet, response);
                        }
                    } catch (NumberFormatException var14) {
                        throw new AssertionError(message);
                    }
                }
            } catch (IOException var15) {
                IOException e = var15;
                if (socket.isClosed()) {
                    return expected;
                } else {
                    throw e;
                }
            }
        };
    }

    private static <T> T select(List<T> items, Random random) {
        return items.get(random.nextInt(items.size()));
    }

    private static String i18n(String request, NumberFormat format) {
        return response(NUMBER.matcher(request).replaceAll((match) -> {
            return format.format((long)Integer.parseInt(match.group()));
        }));
    }

    private static String i18n(String request, String format) {
        return String.format(format, request);
    }

    static void setMode(String test) {
        mode = test.endsWith("-i18n") ? (request, random) -> {
            return random.nextInt(3) == 0 ? response(request) : i18n(request, (NumberFormat)select(FORMATS, random));
        } : (request, random) -> {
            return response(request);
        };
    }

    static {
        CHARSET = StandardCharsets.UTF_8;
        DIGITS_STR = (String)IntStream.rangeClosed(0, 65535).filter(Character::isDigit).mapToObj(Character::toString).collect(Collectors.joining());
        DIGIT = Pattern.compile("([" + DIGITS_STR + "])");
        NUMBER = Pattern.compile("([0-9]+)");
        ANSWER = List.of("Hello, %s", "%s ආයුබෝවන්", "Բարեւ, %s", "مرحبا %s", "Салом %s", "Здраво %s", "Здравейте %s", "Прывітанне %s", "Привіт %s", "Привет, %s", "Поздрав %s", "سلام به %s", "שלום %s", "Γεια σας %s", "העלא %s", "ہیل%s٪ ے", "Bonjou %s", "Bonjour %s", "Bună ziua %s", "Ciao %s", "Dia duit %s", "Dobrý deň %s", "Dobrý den, %s", "Habari %s", "Halló %s", "Hallo %s", "Halo %s", "Hei %s", "Hej %s", "Hello  %s", "Hello %s", "Hello %s", "Helo %s", "Hola %s", "Kaixo %s", "Kamusta %s", "Merhaba %s", "Olá %s", "Ola %s", "Përshëndetje %s", "Pozdrav %s", "Pozdravljeni %s", "Salom %s", "Sawubona %s", "Sveiki %s", "Tere %s", "Witaj %s", "Xin chào %s", "ສະບາຍດີ %s", "สวัสดี %s", "ഹലോ %s", "ಹಲೋ %s", "హలో %s", "हॅलो %s", "नमस्कार%sको", "হ্যালো %s", "ਹੈਲੋ %s", "હેલો %s", "வணக்கம் %s", "ကို %s မင်္ဂလာပါ", "გამარჯობა %s", "ជំរាបសួរ %s បាន", "こんにちは%s", "你好%s", "안녕하세요  %s");
        FORMATS = List.copyOf(((Map)Arrays.stream(Locale.getAvailableLocales()).map(NumberFormat::getNumberInstance).collect(Collectors.toMap((format) -> {
            return format.format(123L);
        }, Function.identity(), (a, b) -> {
            return a;
        }))).values());
        CORRUPTIONS = List.of((s) -> {
            return s.replaceAll("[_\\-]", "0");
        }, (s) -> {
            return DIGIT.matcher(s).replaceAll("$1$1");
        }, (s) -> {
            return DIGIT.matcher(s).replaceFirst("-");
        }, (s) -> {
            return "";
        }, (s) -> {
            return "~";
        });
    }
}
