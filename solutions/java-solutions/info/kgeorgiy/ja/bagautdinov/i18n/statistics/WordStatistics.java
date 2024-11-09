package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.BreakIterator;
import java.util.Locale;

public class WordStatistics extends LetterStatistics {
    public WordStatistics(Locale inputLocale, Locale outputLocale) {
        super(outputLocale, MessageType.WORD);
        this.iterator = BreakIterator.getWordInstance(inputLocale);
    }
}
