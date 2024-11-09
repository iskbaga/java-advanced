package info.kgeorgiy.ja.bagautdinov.i18n;

import info.kgeorgiy.ja.bagautdinov.i18n.statistics.StatsAggregator;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Locale;

public class TextStatistics {
    public static void main(String[] args) {
        if (args == null || args.length != 4) {
            System.err.println("Must be only 4 arguments");
            return;
        }
        for (String arg : args) {
            if (arg == null) {
                System.err.println("Invalid arguments");
                return;
            }
        }
        String[] inputParts = args[0].split("_");
        String[] outputParts = args[1].split("_");
        Locale inputLocale = Locale.of(inputParts[0], inputParts[1]);
        Locale outputLocale = Locale.of(outputParts[0], outputParts[1]);
        Path inputPath, outputPath;
        StatsAggregator aggregator = new StatsAggregator(inputLocale, outputLocale);
        try {
            inputPath = Path.of(args[2]);
        } catch (InvalidPathException e) {
            System.err.println("Problem with text file path: " + e.getMessage());
            return;
        }

        try {
            outputPath = Path.of(args[3]);
        } catch (InvalidPathException e) {
            System.err.println("Problem with stats file path: " + e.getMessage());
            return;
        }
        try {
            String text = Files.readString(inputPath);
            aggregator.analyse(text);
        } catch (IOException e) {
            System.err.println("Problem with text file: " + e.getMessage());
            return;
        }

        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
            writer.write(aggregator.getHead());
            writer.newLine();
            writer.write(aggregator.getSentenceStats());
            writer.newLine();
            writer.write(aggregator.getWordStats());
            writer.newLine();
            writer.write(aggregator.getNumberStats());
            writer.newLine();
            writer.write(aggregator.getMoneyStats());
            writer.newLine();
            writer.write(aggregator.getDateStats());
        } catch (IOException | SecurityException e) {
            System.err.println("Problem with writer " + outputPath + ": " + e);
        } catch (InvalidPathException e) {
            System.err.println("Output file not found " + outputPath + ": " + e);
        }
    }
}
