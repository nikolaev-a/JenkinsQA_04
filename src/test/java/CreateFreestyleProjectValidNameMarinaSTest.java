import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class CreateFreestyleProjectValidNameMarinaSTest extends BaseTest {

    @Test
    public void testCreateFreestyleProjectValidName() {

        String expectedResult = "MarinaTest";

        getDriver().findElement(By.xpath("//div[@id='tasks']//a[@href='/view/all/newJob']")).click();
        getDriver().findElement(By.id("name")).sendKeys("MarinaTest");
        getDriver().findElement(
                By.xpath("//div[@id='j-add-item-type-standalone-projects']//" +
                        "ul[@class='j-item-options']//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen25-button")).click();
        getDriver().findElement(By.xpath("//ul[@id='breadcrumbs']//a[@href='/']")).click();

        String actualResult = getDriver().findElement(
                By.id("main-panel")).findElement(By.linkText("MarinaTest")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

