package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.BreakIterator;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateStatistics extends AbstractStatistics<Date, Long> {
    private final List<DateFormat> dateFormats;
    private final DateFormat outputFormat;

    public DateStatistics(Locale inputLocale, Locale outputLocale) {
        super(outputLocale, MessageType.DATE);
        this.dateFormats = List.of(
                new DateFormat[]{
                        DateFormat.getDateInstance(DateFormat.SHORT, inputLocale),
                        DateFormat.getDateInstance(DateFormat.MEDIUM, inputLocale),
                        DateFormat.getDateInstance(DateFormat.LONG, inputLocale),
                        DateFormat.getDateInstance(DateFormat.FULL, inputLocale)
                });
        this.outputFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, outputLocale);
        this.iterator = BreakIterator.getWordInstance(inputLocale);
    }

    protected boolean isEmpty(Date token) {
        return token.getTime() == 0;
    }

    protected Date getToken(String text) {
        ParsePosition pos = new ParsePosition(this.start);
        for (DateFormat format : dateFormats) {
            Date date = format.parse(text, pos);
            if (date != null) {
                return super.format(date, pos);
            }
        }
        return null;
    }

    protected int compare(Date a, Date b) {
        return Long.compare(a.getTime(), b.getTime());
    }

    protected void updateCount(Date token) {
        this.count += token.getTime();
    }

    protected Date calcMean() {
        if (this.tokenCount == 0) {
            return null;
        }
        return new Date(this.count / this.tokenCount);
    }

    protected Long initCount() {
        return 0L;
    }

    protected String minMaxStr() {
        return "   " +
                MessageFormat.format(bundle.getString("min" + type.getKey()), formatToken(this.minToken)) +
                System.lineSeparator() +
                "   " +
                MessageFormat.format(bundle.getString("max" + type.getKey()), formatToken(this.maxToken)) +
                System.lineSeparator();
    }

    protected String tokenToStr(Date token) {
        return outputFormat.format(token);
    }
}