package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class Song99BottlesJuliaChTest extends BaseTest {
    private static final String BASE_URL = "http://www.99-bottles-of-beer.net";

    private void getBottles(StringBuilder lyrics, int number, String btl) {
        lyrics.append(number).append(btl);
    }

    private void getNoMore(StringBuilder lyrics, String noMore, String btl) {
        lyrics.append(noMore).append(btl);
    }

    private String createLyrics() {
        final String BOTTLES_WALL_CS = " bottles of beer on the wall, ";
        final String BOTTLES_DOT_LN = " bottles of beer.\n";
        final String BOTTLES_DOT = " bottles of beer on the wall.";
        final String TAKE = "Take one down and pass it around, ";
        final String GO = "Go to the store and buy some more, ";
        final String NO_MORE = "No more";

        StringBuilder lyrics = new StringBuilder();

        getBottles(lyrics, 99, BOTTLES_WALL_CS);
        getBottles(lyrics, 99, BOTTLES_DOT_LN);
        for (int i = 98; i > -1; i--) {
            lyrics.append(TAKE);

            if (i == 1) {
                getBottles(lyrics, i, BOTTLES_DOT.replace("s", ""));
                getBottles(lyrics, i, BOTTLES_WALL_CS.replace("s", ""));
                getBottles(lyrics, i, BOTTLES_DOT_LN.replace("s", ""));
            } else if (i == 0) {
                getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT);
                getNoMore(lyrics, NO_MORE, BOTTLES_WALL_CS);
                getNoMore(lyrics, NO_MORE.toLowerCase(), BOTTLES_DOT_LN);
            } else {
                getBottles(lyrics, i, BOTTLES_DOT);
                getBottles(lyrics, i, BOTTLES_WALL_CS);
                getBottles(lyrics, i, BOTTLES_DOT_LN);
            }
        }
        lyrics.append(GO);
        getBottles(lyrics, 99, BOTTLES_DOT);

        return lyrics.toString();
    }

    @Test
    public void testSongLyricsText() {
        final String expectedResult = createLyrics();
        By pTags = By.xpath("//div[@id='main']/p");
        By menuSongLyrics = By.linkText("Song Lyrics");

        getDriver().get(BASE_URL);
        getDriver().findElement(menuSongLyrics).click();

        StringBuilder actualResult = new StringBuilder();

        List<WebElement> pAll = getDriver().findElements(pTags);
        for (WebElement p : pAll) {
            actualResult.append(p.getText());
        }

        Assert.assertEquals(actualResult.toString(), expectedResult);
    }

    @Test
    public void testListOfAllLanguage() {

        String expectedResult =
                "All languages starting with the letter J are shown, sorted by Language.";

        getDriver().get("http://www.99-bottles-of-beer.net/");
        getDriver().findElement(
                By.xpath("//body/div[@id='wrap']/div[@id='navigation']/" +
                        "ul[@id='menu']/li/a[@href='/abc.html']")).click();
        getDriver().findElement(By.xpath("//div/ul[@id='submenu']/li/a[@href='j.html']")).click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//div[@id='wrap']/div[@id='main']/p")).getText(), expectedResult);
    }

    @Test
    public void testLastLanguageMySQL() {

        String expectedResult = "MySQL";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                "/ul[@id='menu']/li/a[@href='/abc.html']")).click();
        getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='m.html']")).click();
        WebElement text = getDriver().findElement(
                By.xpath("//div[@id='main']/table//a[@href='language-mysql-1252.html']"));

        Assert.assertEquals(text.getText(), expectedResult);
    }

    @Test
    public void testTitleOfTable() {

        String expectedResult = "Language Author Date Comments Rate";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']" +
                "/ul[@id='menu']/li/a[@href='/abc.html']")).click();
        WebElement table = getDriver().findElement(By.xpath("//div[@id='main']/table//tr"));

        Assert.assertEquals(table.getText(), expectedResult);
    }

    @Test
    public void testMathematica() {

        String expectedResult = "Mathematica Brenton Bostick 03/16/06 1";

        getDriver().get("http://www.99-bottles-of-beer.net/");

        getDriver().findElement(By.xpath("//body/div[@id='wrap']/div[@id='navigation']/" +
                "ul[@id='menu']/li/a[@href='/abc.html']")).click();
        getDriver().findElement(
                By.xpath("//div[@id='navigation']/ul[@id='submenu']/li/a[@href='m.html']")).click();
        WebElement text = getDriver().findElement(
                By.xpath("//table[@id='category']//a[@href='language-mathematica-1090.html']/../.."));

        Assert.assertEquals(text.getText(), expectedResult);
    }
}

