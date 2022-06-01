package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class FirstLanguageInRZhunatTest extends BaseTest {

    @Test
    public void testFirstLanguageInR() {

        String expectedResult = "R";

        getDriver().get("http://www.99-bottles-of-beer.net");

        getDriver().findElement(By.xpath("//li/a[@href='/abc.html']")).click();

        getDriver().findElement(By.xpath("//a[@href='r.html']")).click();

        WebElement firstRowlanguage = getDriver().findElement(By.xpath("//tr/td/a"));
        String actualResult = firstRowlanguage.getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}