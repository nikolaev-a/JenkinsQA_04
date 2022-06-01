package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;
import java.util.List;

public class Song99BottlesNataliiaOliverHW12Test extends BaseTest {
    private static final String BASE_URL = "http://99-bottles-of-beer.net/lyrics.html";
    private static final String BROWSE_LANGUAGES = "//ul[@id='menu']/li/a[@href='/abc.html']";

    @Test
    public void testLanguagesStartJ_TC_12_01() {

        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANGUAGES)).click();
        getDriver().findElement(By.xpath("//a[@href='j.html']")).click();

        String actualResult = getDriver().findElement(By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMLastTableLanguageMySQL_TC_12_02() {

        String expectedResult = "MySQL";

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANGUAGES)).click();
        getDriver().findElement(By.xpath("//a[@href='m.html']")).click();

        String actualResult = getDriver().findElement(By.xpath("//tr[last()]/td/a")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTableHeaders_TC_12_03() {

        String[] expectedResult = {"Language", "Author", "Date", "Comments", "Rate"};

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANGUAGES)).click();

        String[] actualResult = new String[5];
        for (int i = 0; i < actualResult.length; i++) {
            int index = i + 1;
            actualResult[i] = getDriver()
                    .findElement(By.xpath("//tbody/tr/th[" + index + "]"))
                    .getText();
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMathematicaLanguage_TC_12_04() {

        String expectedResultLanguage = "Mathematica";
        String expectedResultCreator = "Brenton Bostick";
        String expectedResultData = "03/16/06";
        String expectedResultComments = "1";

        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append(expectedResultLanguage)
                .append(" ")
                .append(expectedResultCreator)
                .append(" ")
                .append(expectedResultData)
                .append(" ")
                .append(expectedResultComments);

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANGUAGES)).click();
        getDriver().findElement(By.linkText("M")).click();

        List<WebElement> trs = getDriver().findElements(By.xpath("//table[@id='category']/tbody/tr"));

        List<String> actualResult = new ArrayList<>();

        for (WebElement tr : trs) {
            if (tr.getText().contains(expectedResultLanguage)) {
                actualResult.add(tr.getText());
            }
        }

        Assert.assertEquals(actualResult.size(), 1);
        Assert.assertFalse(actualResult.get(0).isEmpty());
        Assert.assertEquals(actualResult.get(0), expectedResult.toString());
    }

    @Test
    public void testTenLanguagesStartWithNumbers_TC_12_05() {

        int expectedResult = 10;

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath(BROWSE_LANGUAGES)).click();
        getDriver().findElement(By.xpath("//a[@href='0.html'] ")).click();

        int actualResult = getDriver().findElements(By.xpath("//tbody/tr/td/a")).size();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testErrorMessage_TC_12_06() {

        String expectedResult = "Error: Error: Invalid security code.";

        String random = "" + ((int) (Math.random() * 900) + 100);

        getDriver().get(BASE_URL);
        getDriver().findElement(By.xpath("//a[@href='/guestbookv2.html']")).click();
        getDriver().findElement(By.xpath("//a[@href='./signv2.html']")).click();
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Nataliia");
        getDriver().findElement(By.xpath("//input[@name='location']")).sendKeys("Louisiana");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("psvnatali@gmail.com");
        getDriver().findElement(By.xpath("//input[@name='homepage']")).sendKeys("lagoldgymnastics.com");
        getDriver().findElement(By.xpath("//input[@name='captcha']")).sendKeys(random);
        getDriver().findElement(By.xpath("//textarea[@name='comment']")).sendKeys("test message");
        getDriver().findElement(By.xpath("//input[@type='submit']")).click();

        String actualResult = getDriver()
                .findElement(By.xpath("//div[@id='main']//p[contains(text(),' Error: Invalid security code.')]"))
                .getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
