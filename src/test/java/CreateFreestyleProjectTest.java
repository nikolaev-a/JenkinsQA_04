import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class CreateFreestyleProjectTest extends BaseTest {

    @Test
    public void testCreateFreestyleProjectValidName() {

        String expectedResult = "MSTest";

        getDriver().findElement(By.xpath("//a[@href='/view/all/newJob']//span[@class='task-link-text']")).click();
        getDriver().findElement(By.xpath("//div[@class='add-item-name']//input[@id='name']")).sendKeys("MSTest");
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']/label")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen25-button")).click();
        getDriver().findElement(By.xpath("//ul[@id='breadcrumbs']//a[@href='/']")).click();
        String actualResult = getDriver().findElement(By.id("main-panel")).findElement(By.linkText("MSTest")).getText();

        Assert.assertEquals(actualResult, expectedResult);
    }

}
