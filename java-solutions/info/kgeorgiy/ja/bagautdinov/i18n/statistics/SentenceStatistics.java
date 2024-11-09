package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.BreakIterator;
import java.util.Locale;

public class SentenceStatistics extends LetterStatistics {
    public SentenceStatistics(Locale inputLocale, Locale outputLocale) {
        super(outputLocale, MessageType.SENTENCE);
        this.iterator = BreakIterator.getSentenceInstance(inputLocale);
    }
}
