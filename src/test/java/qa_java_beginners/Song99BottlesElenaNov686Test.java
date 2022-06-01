package qa_java_beginners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class Song99BottlesElenaNov686Test extends BaseTest {
    private static final String BASE_URL = "http://www.99-bottles-of-beer.net/lyrics.html";

    private void getBottles(StringBuilder lyrics, int number,String btl){
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

        lyrics
                .append(99)
                .append(BOTTLES_DOT_LN);

        for (int i = 98; i > -1; i--) {
            lyrics.append(TAKE);
            if (i == 1) {
                lyrics
                        .append(i)
                        .append(BOTTLES_DOT.replace("s", ""))
                        .append(i)
                        .append(BOTTLES_WALL_CS.replace("s", ""))
                        .append(i)
                        .append(BOTTLES_DOT_LN.replace("s", ""));
            } else if (i == 0) {
                lyrics
                        .append(NO_MORE.toLowerCase())
                        .append(BOTTLES_DOT)
                        .append(NO_MORE)
                        .append(BOTTLES_WALL_CS)
                        .append(NO_MORE.toLowerCase())
                        .append(BOTTLES_DOT_LN);

            } else {
                lyrics
                        .append(i)
                        .append(BOTTLES_DOT)
                        .append(i)
                        .append(BOTTLES_WALL_CS)
                        .append(i)
                        .append(BOTTLES_DOT_LN);
            }
        }

        lyrics.append(GO);
        getBottles(lyrics, 99,BOTTLES_DOT);


        return lyrics.toString();
    }

    @Test
    public void testSongLyricsText(){

        final String expectedResult = createLyrics();
        By pTags = By.xpath("//div[@id='main']/p");
        By menuSongLyrics = By.linkText("Song Lyrics");

        getDriver().get(BASE_URL);
        getDriver().findElement(menuSongLyrics).click();

        List<WebElement> pAll =getDriver().findElements(pTags);

        StringBuilder actualResult = new StringBuilder();

        for (WebElement p : pAll){
            actualResult.append(p.getText());
        }

        Assert.assertEquals(actualResult.toString(), expectedResult);
    }
}
