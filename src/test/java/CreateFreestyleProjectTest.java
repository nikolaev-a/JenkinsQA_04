import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class CreateFreestyleProjectTest extends BaseTest {

    public final String FreestyleProjectName = "MarinaTest";

    @Test
    public void testCreateFreestyleProjectValidName() {

        String expectedResult = "MarinaTest";

        getDriver().findElement(
                By.xpath("//div[@id='side-panel']//span[@class='task-link-text']")).click();
        getDriver().findElement(
                        By.xpath("//div[@id='main-panel']//div[@class='add-item-name']/input"))
                .sendKeys(FreestyleProjectName);
        getDriver().findElement(
                By.xpath("//div[@id='main-panel']//div[@class='col-md-offset-2 col-md-20']" +
                        "//ul[@class='j-item-options']//li[@tabindex='0']" +
                        "//label/span[(contains(text(),'Freestyle project'))]")).click();
        getDriver().findElement(
                By.xpath("//div[@id='main-panel']/div//form[@method='post']" +
                        "//div[@class='btn-decorator']/span")).click();
        getDriver().findElement(
                        By.xpath("//div[@id='bottom-sticker']/div[@class='bottom-sticker-inner']" +
                                "/span[1]"))
                .click();
        getDriver().findElement(
                By.xpath("//div[@id='tasks']/div[@class='task ']//a[@href='/']" +
                        "/span[@class='task-link-text']")).click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//table[@id='projectstatus']//tr[@id='job_MarinaTest']" +
                        "//a[@href='job/MarinaTest/']")).getText(), expectedResult);
    }

}


