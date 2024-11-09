package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.MessageFormat;
import java.util.Locale;

abstract class LetterStatistics extends AbstractStatistics<String, Long> {
    protected String maxTokenLexical;
    protected String minTokenLexical;

    LetterStatistics(Locale outputLocale, MessageType type) {
        super(outputLocale, type);
    }

    protected String getToken(String text) {
        String token = text.substring(start, end).trim();
        if (token.chars().anyMatch(Character::isLetter)) {
            return token;
        }
        return null;
    }

    protected boolean isEmpty(String token) {
        return token.isEmpty();
    }

    protected int compare(String a, String b) {
        return Integer.compare(a.length(), b.length());
    }

    protected void updateCount(String token) {
        this.count += token.length();
    }

    protected Long initCount() {
        return 0L;
    }

    protected String tokenToStr(String token) {
        return token;
    }

    @Override
    protected String lexicalMinMaxStr() {
        return "   " +
                MessageFormat.format(bundle.getString("min" + type.getKey()), formatToken(this.minTokenLexical)) +
                System.lineSeparator() +
                "   " +
                MessageFormat.format(bundle.getString("max" + type.getKey()), formatToken(this.maxTokenLexical)) +
                System.lineSeparator();
    }

    protected String minMaxStr() {
        return "   " +
                MessageFormat.format(bundle.getString("minLen" + type.getKey()), formatToken(this.minToken), getLength(this.minToken)) +
                System.lineSeparator() +
                "   " +
                MessageFormat.format(bundle.getString("maxLen" + type.getKey()), formatToken(this.maxToken), getLength(this.maxToken)) +
                System.lineSeparator();
    }

    private int getLength(String token) {
        if (token == null) {
            return 0;
        }
        return token.length();
    }

    protected String calcMean() {
        if (this.tokenCount == 0) {
            return bundle.getString("emptyToken");
        }
        double result = (double) this.count / this.tokenCount;
        return String.format("%.3f", result);
    }


    @Override
    protected void update(String token) {
        super.update(token);
        if (minTokenLexical == null || token.compareTo(minTokenLexical) < 0) {
            this.minTokenLexical = token;
        }
        if (maxTokenLexical == null || token.compareTo(maxTokenLexical) > 0) {
            this.maxTokenLexical = token;
        }
    }
}
