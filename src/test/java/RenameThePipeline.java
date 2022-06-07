import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.concurrent.TimeUnit;

public class RenameThePipeline extends BaseTest {
    private final String PROJECT_NAME = "TestingTheWebsite";

    protected void createPipeline() {
        getDriver().findElement(By.cssSelector("span[class='task-link-text']")).click();
        WebElement entryField = getDriver().findElement(By.id("name"));
        entryField.sendKeys(PROJECT_NAME);
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div/div/div/form/div[2]/div[1]/ul/li[2]")).click();
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        WebElement saveButton = getDriver().findElement(By.cssSelector("button[type='submit'][tabindex='0']"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", saveButton);
    }
    protected void deleteProject() throws InterruptedException {
        getDriver().findElement(By.cssSelector("img#jenkins-head-icon")).click();
        //getDriver().findElement(By.xpath("//a[contains(@href, 'ChangedName')]")).click();
        getDriver().findElement(By.xpath("//*[@id=\"tasks\"]/div[6]/span/a/span[1]")).click();
        //FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver()).withTimeout(20, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS);
        Thread.sleep(3000);
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void renameTest() throws InterruptedException {

        createPipeline();
        WebElement configureButton = getDriver().findElement(By.cssSelector("a[title='Configure']"));
        configureButton.click();
        WebElement advancedButton = getDriver().findElement(By.xpath("/html/body/div[5]/div/div/div/div/form/div[1]/div[7]/div[2]/div[1]/span[2]"));
        getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //advancedButton.click();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", advancedButton);
        getDriver().findElement(By.xpath("//*[@id=\"main-panel\"]/div/div/div/form/div[1]/div[7]/div[3]/div/div[2]/input")).sendKeys("ChangedName");
        WebElement saveButton = getDriver().findElement(By.xpath("//*[@id=\"yui-gen6-button\"]"));
        saveButton.click();
        String expectedName = "Pipeline ChangedName";
        String  actualName = getDriver().findElement(By.cssSelector("h1[class='job-index-headline page-headline']")).getText();
        Assert.assertEquals(actualName, expectedName);

        //deleteProject();
    }
}
