package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class LassaulHW12Test extends BaseTest {

    private static final String BASEURL = "http://www.99-bottles-of-beer.net/";

    private WebElement findMenu (String href) {
        return getDriver().findElement(By.xpath("//ul[@id = 'menu']//a[@href='" + href + "']"));
    }

    private WebElement findSubMenuBrowserLanguage (String letter) {
        return getDriver().findElement(By.xpath("//ul[@id = 'submenu']//a[@href='" + letter + ".html']"));
    }

    private WebElement findSubMenuTopLists (String href) {
        return getDriver().findElement(By.xpath("//ul[@id = 'submenu']//a[@href='" + href + "']"));
    }

    private WebElement chooseLanguage (String languageName) {
        return getDriver().findElement(By.xpath("//table[@id='category']//a[text()='" + languageName + "']"));
    }

    @Test
    public void testPageDescriptionForJ () {
        String expectedResult = "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("j").click();

        String actualResult = getDriver().findElement(By.xpath("//div[@id = 'main']/p[1]")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLastProgramLanguageStartingWithM () {
        String expectedResult = "MySQL";

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("m").click();

        String actualResult = getDriver().findElement(
                By.xpath("//tr[last()]//a[@href='language-mysql-1252.html']")
        ).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTableColumnsNameBrowseLanguagesPage () {
        String[] expectedResult = {"Language", "Author", "Date", "Comments", "Rate"};

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();

        String[] actualResult = new String[5];

        for (int i = 0; i < actualResult.length; i++) {
            int index = i + 1;
            actualResult[i] = getDriver().findElement(
                    By.xpath("//table[@id = 'category']//tr[1]/th[" + index + "]")
            ).getText();
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testMathematicaLanguageAttributes() {
        String expectedResult1 = "Brenton Bostick";
        String expectedResult2 = "03/16/06";
        String expectedResult3 = "1";

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("m").click();
        getDriver().findElement(By.xpath("//a[@href='language-mathematica-1090.html']")).click();

        String actualResult1 = getDriver().findElement(By.xpath("//strong[text()='Author:']/..//../td[last()]")).getText();
        String actualResult2 = getDriver().findElement(By.xpath("//strong[text()='Date:']/..//../td[last()]")).getText();
        String actualResult3 = getDriver().findElement(By.xpath("//strong[text()='Comments:']/..//../td[last()]")).getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);
    }

    @Test
    public void testQuantityOfNumericLanguageNames() {
        int expectedResult = 10;

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("0").click();

        List <WebElement> languageQuantity = getDriver().findElements(By.xpath("//table[@id='category']//tr"));
        int actualResult = languageQuantity.size() - 1;

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testErrorMessageSignGuestbookPage() {
        String expectedResult = "Error: Error: Invalid security code.";

        getDriver().get("http://www.99-bottles-of-beer.net/signv2.html");
        getDriver().findElement(By.xpath("//input[@name='name']")).sendKeys("Liubov");
        getDriver().findElement(By.xpath("//input[@name='location']")).sendKeys("Kyiv");
        getDriver().findElement(By.xpath("//input[@name='email']")).sendKeys("magessa@ukr.net");
        getDriver().findElement(
                        By.xpath("//input[@name='captcha']"))
                .sendKeys(String.valueOf(100 + (int)(Math.random() * 900)));
        getDriver().findElement(By.xpath("//textarea[@name='comment']")).sendKeys("Good site.");
        getDriver().findElement(By.xpath("//input[@name='submit']")).click();

        String actualResult = getDriver().findElement(By.xpath("//div[@id='main']/p")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testRedditBookmark() throws InterruptedException {
        String expectedResult = "reddit.com: Log in";

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("c").click();
        chooseLanguage("C#").click();

        if (getDriver().findElement(By.xpath("//div[@id='alternatives']//table[@id='category']")).isDisplayed()) {
            getDriver().findElement(By.xpath("//table[@id='category']//tr[2]//a")).click();
        }

        getDriver().findElement(By.xpath("//a[@title='reddit']")).click();
        Thread.sleep(700);

        String actualResult = getDriver().getTitle();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLanguageTopRated() {
        String language = "Shakespeare";
        boolean expectedResult = true;

        getDriver().get(BASEURL);
        findMenu("/toplist.html").click();
        findSubMenuTopLists("./toplist.html").click();

        List <WebElement> top20Languages = getDriver().findElements(
                By.xpath("//table[@id='category']//a")
        ).subList(0, 20);

        boolean actualResult = false;

        for (WebElement topLanguage:
             top20Languages) {
            if (topLanguage.getText().equals(language)) {
                actualResult = true;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLanguageTopRatedEsoteric() {
        String language = "Shakespeare";
        boolean expectedResult = true;

        getDriver().get(BASEURL);
        findMenu("/toplist.html").click();
        findSubMenuTopLists("./toplist_esoteric.html").click();

        List <WebElement> top10Languages = getDriver().findElements(
                By.xpath("//table[@id='category']//a")
        ).subList(0, 10);

        boolean actualResult = false;

        for (WebElement topLanguage:
                top10Languages) {
            if (topLanguage.getText().equals(language)) {
                actualResult = true;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testLanguageTopHits() {
        String language = "Shakespeare";
        boolean expectedResult = true;

        getDriver().get(BASEURL);
        findMenu("/toplist.html").click();
        findSubMenuTopLists("./tophits.html").click();

        List <WebElement> top6Languages = getDriver().findElements(
                By.xpath("//table[@id='category']//a")
        ).subList(0, 6);

        boolean actualResult = false;

        for (WebElement topLanguage:
                top6Languages) {
            if (topLanguage.getText().equals(language)) {
                actualResult = true;
            }
        }

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testQuantityOfJavaVersions () {
        int expectedResult = 6;

        getDriver().get(BASEURL);
        findMenu("/abc.html").click();
        findSubMenuBrowserLanguage("j").click();
        chooseLanguage("Java").click();

        List<WebElement> languageVersions = getDriver().findElements(By.xpath("//table[@id='category']//tr//a"));

        int actualResult = languageVersions.size() + 1;

        Assert.assertEquals(actualResult, expectedResult);
    }




}
