package info.kgeorgiy.ja.bagautdinov.walk;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

class Hasher {
    public static final int BUFFER_LENGTH = 1024;
    public static final String ERROR_HASH = String.format("%08x", 0);

    private Hasher() {
    }

    public static String hash(Path path) {
        try (InputStream stream = Files.newInputStream(path)) {
            int hash = 0;
            byte[] buffer = new byte[BUFFER_LENGTH];
            int length = 0;
            while ((length = stream.read(buffer)) != -1) {
                for (int i = 0; i < length; i++) {
                    hash += buffer[i] & 0xff;
                    hash += hash << 10;
                    hash ^= hash >>> 6;
                }
            }
            hash += hash << 3;
            hash ^= hash >>> 11;
            hash += hash << 15;
            return String.format("%08x", hash);
        } catch (IOException | SecurityException exc) {
            return ERROR_HASH;
        }
    }
}