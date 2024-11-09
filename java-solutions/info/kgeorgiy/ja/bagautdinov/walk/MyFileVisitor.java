package info.kgeorgiy.ja.bagautdinov.walk;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class MyFileVisitor extends SimpleFileVisitor<Path> {
    private final BufferedWriter writer;
    public MyFileVisitor(BufferedWriter writer){
        this.writer = writer;
    }
    public void writeError(String file) throws IOException {
        writer.append(Hasher.ERROR_HASH)
                .append(" ")
                .append(file).append(System.lineSeparator());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
        writer.append(Hasher.hash(file))
                .append(" ")
                .append(file.toString()).append(System.lineSeparator());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException e) throws IOException {
        writeError(file.toString());
        return FileVisitResult.CONTINUE;
    }
}