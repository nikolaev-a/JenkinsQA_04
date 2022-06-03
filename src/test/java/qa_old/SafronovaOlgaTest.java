package qa_old;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

@Ignore
public class SafronovaOlgaTest extends BaseTest {

    @Test
    public void Test () {

        getDriver().get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement searchInput = getDriver().findElement(By.xpath("//input[@id='searchInput']"));
        searchInput.sendKeys("QA tester");

        searchInput.sendKeys(Keys.ENTER);

        WebElement searchResult = getDriver().findElement(By.xpath("//h1[@id='firstHeading']"));

        String searchResultText = searchResult.getText();

        Assert.assertEquals(searchResultText, "Search results");

    }

    @Test
    public  void SafOlgaTest ()  {
        final String URL = "http://www.99-bottles-of-beer.net/";
        String expectedResult = "Welcome to 99 Bottles of Beer";

        getDriver().get(URL);

        WebElement menuBrowseLanguages = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/abc.html']")

        );
        menuBrowseLanguages.click();

        WebElement menuStart = getDriver().findElement(
                By.xpath("//ul[@id='menu']/li/a[@href='/']"));
        menuStart.click();

        WebElement h2 =getDriver().findElement(By.xpath("//div[@id='main']/h2"));

        String actualResult = h2.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}