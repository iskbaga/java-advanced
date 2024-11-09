package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyStatistics extends DigitStatistics {
    public MoneyStatistics(Locale inputLocale, Locale outputLocale) {
        super(inputLocale, outputLocale, MessageType.MONEY);
        this.inputFormat = NumberFormat.getCurrencyInstance(inputLocale);
        this.outputFormat = NumberFormat.getCurrencyInstance(outputLocale);
    }
}