package info.kgeorgiy.ja.bagautdinov.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextStatisticsTest {
    private static final String DIRECTORY = "solutions/test-resources";
    private static final Charset CHARSET = StandardCharsets.UTF_8;
    private static final String en_US_arg = "en_US";
    private static final String ru_RU_arg = "ru_RU";
    private static final String zh_CN_arg = "zh_CN";

    private void test(String testName, String inputLocale, String outputLocale) throws IOException {
        String inputPath = DIRECTORY + "/" + testName + ".txt";
        String outputPath = DIRECTORY + "/" + testName + "_" + "Test.txt";
        String testFilePath = DIRECTORY + "/" + testName + "_" + inputLocale + "_" + outputLocale + ".txt";
        TextStatistics.main(new String[]{inputLocale, outputLocale, inputPath, outputPath});
        Assertions.assertEquals(Files.readString(Path.of(testFilePath), CHARSET), Files.readString(Path.of(outputPath), CHARSET));
        Files.delete(Path.of(outputPath));
    }

    @Test
    public void emptyTextTest() throws IOException {
        test("emptyText", en_US_arg, ru_RU_arg);
        test("emptyText", ru_RU_arg, ru_RU_arg);
        test("emptyText", ru_RU_arg, ru_RU_arg);
    }

    @Test
    public void enToRuTest() throws IOException {
        test("text1", en_US_arg, ru_RU_arg);
    }
    @Test
    public void ruToEnTest() throws IOException {
        test("text1", ru_RU_arg, en_US_arg);
    }

    @Test
    public void enToRuDatesTest() throws IOException {
        test("datesText", en_US_arg, ru_RU_arg);
    }

    @Test
    public void enToEnDatesTest() throws IOException {
        test("datesText", en_US_arg, en_US_arg);
    }

    @Test
    public void ruToRuDatesTest() throws IOException {
        test("datesText", ru_RU_arg, ru_RU_arg);
    }

    @Test
    public void ruToEnDatesTest() throws IOException {
        test("datesText", ru_RU_arg, en_US_arg);
    }

    @Test
    public void enToRuMoneyTest() throws IOException {
        test("moneyText", en_US_arg, ru_RU_arg);
    }

    @Test
    public void enToEnMoneyTest() throws IOException {
        test("moneyText", en_US_arg, en_US_arg);
    }

    @Test
    public void ruToRuMoneyTest() throws IOException {
        test("moneyText", ru_RU_arg, ru_RU_arg);
    }

    @Test
    public void ruToEnMoneyTest() throws IOException {
        test("moneyText", ru_RU_arg, en_US_arg);
    }

    @Test
    public void complexLanguageTest() throws IOException {
        test("chineseText", zh_CN_arg, ru_RU_arg);
    }
}