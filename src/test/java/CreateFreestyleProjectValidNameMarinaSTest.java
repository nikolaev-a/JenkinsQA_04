import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class CreateFreestyleProjectValidNameMarinaSTest extends BaseTest {

    @Test
    public void testCreateFreestyleProjectValidName() {

        String expectedResult = "MarinaTest2";

        getDriver().findElement(By.xpath("//div[@id='tasks']//a[@href='/view/all/newJob']")).click();
        getDriver().findElement(By.id("name")).sendKeys("MarinaTest2");
        getDriver().findElement(
                By.xpath("//div[@id='j-add-item-type-standalone-projects']//" +
                        "ul[@class='j-item-options']//li[@class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.id("ok-button")).click();

        WebElement saveButton = getWait5().until(
                ExpectedConditions.elementToBeClickable(By.id("yui-gen25-button"))
        );
        saveButton.click();
        getDriver().findElement(By.xpath("//ul[@id='breadcrumbs']//a[@href='/']")).click();

        String actualResult = getDriver().findElement(
                By.id("main-panel")).findElement(By.linkText("MarinaTest2")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }
}

