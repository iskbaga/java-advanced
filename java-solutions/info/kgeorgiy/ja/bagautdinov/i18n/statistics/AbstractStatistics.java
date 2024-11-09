package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.text.BreakIterator;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.util.HashSet;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

public abstract class AbstractStatistics<T, V> {
    protected final ResourceBundle bundle;
    protected BreakIterator iterator;
    protected Set<T> sentences;
    protected T minToken;
    protected T maxToken;
    protected V count;
    protected int tokenCount;
    protected int start;
    protected int end;
    protected MessageType type;

    AbstractStatistics(Locale outputLocale, MessageType type) {
        this.type = type;
        this.bundle = ResourceBundle.getBundle("Messages", outputLocale);
    }

    public void analyse(String text) {
        iterator.setText(text);
        start = iterator.first();
        end = iterator.next();
        this.sentences = new HashSet<>();
        this.tokenCount = 0;
        this.count = initCount();
        for (; end != BreakIterator.DONE; start = end, end = iterator.next()) {
            T token = getToken(text);
            if (token != null && !isEmpty(token)) {
                if (!sentences.contains(token)) {
                    update(token);
                } else {
                    updateCount(token);
                }
                this.tokenCount++;
            }
        }
    }

    protected abstract boolean isEmpty(T token);

    protected abstract T getToken(String text);

    protected T format(T token, ParsePosition pos) {
        if (token == null) {
            return null;
        }
        start = pos.getIndex();
        end = iterator.following(start);
        return token;
    }

    protected abstract int compare(T a, T b);

    protected abstract void updateCount(T token);

    protected void update(T token) {
        this.sentences.add(token);
        updateCount(token);
        if (minToken == null || compare(token, minToken) < 0) {
            this.minToken = token;
        }
        if (maxToken == null || compare(token, maxToken) > 0) {
            this.maxToken = token;
        }
    }

    protected abstract V initCount();

    @Override
    public String toString() {
        String sep = System.lineSeparator();
        String tab = "   ";
        StringBuilder sb = new StringBuilder();
        sb.append(bundle.getString("head" + type.getKey()))
                .append(sep)
                .append(tab)
                .append(getCount());
        if (this.sentences.size() > 1) {
            sb.append(MessageFormat.format(bundle.getString("distinct"), this.sentences.size()));
        }
        sb.append(".")
                .append(sep)
                .append(lexicalMinMaxStr())
                .append(minMaxStr())
                .append(tab).append(MessageFormat.format(bundle.getString("mean" + type.getKey()),
                        formatToken(calcMean())));
        return sb.toString();
    }

    protected abstract String minMaxStr();

    protected String getCount() {
        return MessageFormat.format(bundle.getString("count" + type.getKey()), this.tokenCount);
    }

    protected String lexicalMinMaxStr() {
        return "";
    }

    protected abstract T calcMean();

    protected abstract String tokenToStr(T token);

    protected String formatToken(T token) {
        if (token == null) {
            return bundle.getString("emptyToken");
        }
        return tokenToStr(token);
    }
}


