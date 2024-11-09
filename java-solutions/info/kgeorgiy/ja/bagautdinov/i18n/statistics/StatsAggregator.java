package info.kgeorgiy.ja.bagautdinov.i18n.statistics;

import java.util.Locale;
import java.util.ResourceBundle;

public class StatsAggregator {
    final private SentenceStatistics sentenceStats;
    final private MoneyStatistics moneyStats;
    final private WordStatistics wordStats;
    final private DateStatistics dateStats;
    final private NumberStatistics numberStats;
    final private ResourceBundle bundle;

    public StatsAggregator(Locale inputLocale, Locale outputLocale) {
        sentenceStats = new SentenceStatistics(inputLocale, outputLocale);
        moneyStats = new MoneyStatistics(inputLocale, outputLocale);
        wordStats = new WordStatistics(inputLocale, outputLocale);
        dateStats = new DateStatistics(inputLocale, outputLocale);
        numberStats = new NumberStatistics(inputLocale, outputLocale);
        bundle = ResourceBundle.getBundle("Messages", outputLocale);
    }

    public void analyse(String text) {
        sentenceStats.analyse(text);
        moneyStats.analyse(text);
        wordStats.analyse(text);
        dateStats.analyse(text);
        numberStats.analyse(text);
    }

    public String getHead() {
        String sepTab = System.lineSeparator() + "   ";
        return bundle.getString("stats") +
                sepTab +
                sentenceStats.getCount() +
                sepTab +
                wordStats.getCount() +
                sepTab +
                numberStats.getCount() +
                sepTab +
                moneyStats.getCount() +
                sepTab +
                dateStats.getCount();
    }

    public String getSentenceStats() {
        return sentenceStats.toString();
    }

    public String getMoneyStats() {
        return moneyStats.toString();
    }

    public String getWordStats() {
        return wordStats.toString();
    }

    public String getDateStats() {
        return dateStats.toString();
    }

    public String getNumberStats() {
        return numberStats.toString();
    }
}
