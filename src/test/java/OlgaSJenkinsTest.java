import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class OlgaSJenkinsTest extends BaseTest {

    private void deleteFreestyleProject () {

        getDriver().findElement(
                By.xpath(
                        "//div[@id='tasks']/div/span[@class='task-link-wrapper ']/a[@data-url='/job/My%20first%20item/doDelete']"))
                .click();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void testCreatedFirstTest () {
        Assert.assertTrue(getDriver().findElement(By.id("side-panel")).isDisplayed());
    }

    @Test
    public void testCreatedFreestyleProject () {
        final String projectName = "My first item";
        final String projectDescription = "add my first item";

        getDriver().findElement(By.xpath("//div[@id='side-panel']/div[@id='tasks']//a[@href='/view/all/newJob']"))
                .click();
        getDriver().findElement(By.id("name"))
                .sendKeys(projectName);
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"))
                .click();
        getDriver().findElement(By.id("ok-button"))
                .click();
        getDriver().findElement(By.xpath("//textarea[@name='description']"))
                .sendKeys(projectDescription);
        getDriver().findElement(
                By.xpath("//div[@class='bottom-sticker-inner']"))
                .click();

        String actualResult = getDriver().findElement(By.xpath(
                "//div[@id='main-panel']/div[@id='description']/div[1]")).getText();

        deleteFreestyleProject();

        Assert.assertEquals(actualResult, projectDescription);
    }

    @Test
    public void testFreestyleProjectNameEmpty() {
        String expectedResultError = "Error";
        String expectedResultDoshboard = "Dashboard";
        getDriver().findElement(By.xpath("//div[@id='side-panel']/div[@id='tasks']//a[@href='/view/all/newJob']"))
                .click();
        getDriver().findElement(By.id("name"))
                .sendKeys("          ");
        getDriver().findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']"))
                .click();
        getDriver().findElement(By.id("ok-button"))
                .click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//div[@id='page-body']/div[@id='main-panel']/h1")).getText(),expectedResultError);

        getDriver().findElement(By.xpath(
                "//div[@id='breadcrumbBar']//a[@class=' inside breadcrumbBarAnchor']")).click();

        Assert.assertEquals(getDriver().findElement(By.xpath(
                        "//div[@id='breadcrumbBar']//a[@class='model-link inside breadcrumbBarAnchor']"))
                .getText(),expectedResultDoshboard);
    }
}
