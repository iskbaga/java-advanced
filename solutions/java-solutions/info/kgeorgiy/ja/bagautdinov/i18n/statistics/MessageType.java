package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

public enum MessageType {
    SENTENCE("Sentence"),
    MONEY("Money"),
    DATE("Date"),
    NUMBER("Number"),
    WORD("Word");

    private final String key;

    MessageType(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}