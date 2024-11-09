package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.NumberFormat;
import java.util.Locale;

public class NumberStatistics extends DigitStatistics {
    public NumberStatistics(Locale inputLocale, Locale outputLocale) {
        super(inputLocale, outputLocale, MessageType.NUMBER);
        this.inputFormat = NumberFormat.getNumberInstance(inputLocale);
        this.outputFormat = NumberFormat.getNumberInstance(outputLocale);
    }
}