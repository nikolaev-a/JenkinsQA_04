package qa_java_beginners;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class GalaKonHW12Song99BottlesTest extends BaseTest {

    public static final String URL = "http://www.99-bottles-of-beer.net";

    @Test
    public void testLanguageNamesStartFromJ() throws InterruptedException {

        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get(URL);

        getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul[@id='menu']/li/a[@href='/abc.html']")
        ).click();

        getDriver().findElement(
                By.xpath("//a[@href='j.html']")
        ).click();

        String actualResult = getDriver().findElement(
                By.xpath("//div[@id='main']/p[1]")
        ).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    /**
     * Подтвердите, что в меню BROWSE LANGUAGES, подменю  M, последний программный язык в таблице -  MySQL
     * Шаги:
     * Открыть базовую страницу
     * Нажать на пункт меню BROWSE LANGUAGES
     * Нажать на подменю M
     * Подтвердить, что последний язык программирования на странице - MySQL
     */
    @Test
    public void test() throws InterruptedException {

        String expectedResult = "";

    }

}
