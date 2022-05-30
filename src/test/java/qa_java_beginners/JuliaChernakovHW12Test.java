package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class JuliaChernakovHW12Test extends BaseTest {
    /**
     * Подтвердите, что в меню BROWSE LANGUAGES, подменю  J, пользователь
     * может найти описание страницы, на которой перечеслены все программные языки,
     * начинающиеся с буквы J, отсортированные по названию
     */
    @Test
    public void testPageDescription() {
        String chromeDriver = "webdriver.chrome.driver";
        String driverPath = "/Applications/chromedriver";
        String url = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        System.setProperty(chromeDriver, driverPath);
        WebDriver driver = new ChromeDriver();

        driver.get(url);

        WebElement menuBrowseLanguages = driver.findElement(By.xpath("//li/a[@href='/abc.html']"));
        menuBrowseLanguages.click();

        WebElement submenuJ = driver.findElement(By.xpath("//a[@href='j.html']"));
        submenuJ.click();

        WebElement text = driver.findElement(By.xpath("//p[strong]"));
        String actualResult = text.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }
}

