package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.BreakIterator;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Locale;

public abstract class DigitStatistics extends AbstractStatistics<Number, Double> {
    protected NumberFormat inputFormat;
    protected NumberFormat outputFormat;

    public DigitStatistics(Locale inputLocale, Locale outputLocale, MessageType type) {
        super(outputLocale, type);
        this.iterator = BreakIterator.getWordInstance(inputLocale);
    }

    protected Number getToken(String text) {
        ParsePosition pos = new ParsePosition(this.start);
        Number token = inputFormat.parse(text, pos);
        return super.format(token, pos);
    }

    protected int compare(Number a, Number b) {
        double x = a.doubleValue();
        double y = b.doubleValue();
        return Double.compare(x, y);
    }

    protected void updateCount(Number token) {
        this.count += token.doubleValue();
    }

    protected Double initCount() {
        return 0.0;
    }

    protected boolean isEmpty(Number token) {
        return token.doubleValue() == 0.0;
    }

    protected String tokenToStr(Number token) {
        return this.outputFormat.format(token);
    }

    protected Double calcMean() {
        if (this.tokenCount == 0) {
            return 0.0;
        }
        return this.count / this.tokenCount;
    }

    protected String minMaxStr() {
        return "   " +
                MessageFormat.format(bundle.getString("min" + type.getKey()), formatToken(this.minToken)) +
                System.lineSeparator() +
                "   " +
                MessageFormat.format(bundle.getString("max" + type.getKey()), formatToken(this.maxToken)) +
                System.lineSeparator();
    }


}
