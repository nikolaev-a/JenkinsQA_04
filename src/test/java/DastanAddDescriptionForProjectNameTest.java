import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DastanAddDescriptionForProjectNameTest extends BaseTest {

    private final String PROJECT_NAME = "Some_Project";

    protected void addDescription() {
        getDriver().findElement(By.cssSelector("span[class='task-link-text']")).click();
        WebElement entryField = getDriver().findElement(By.id("name"));
        entryField.sendKeys(PROJECT_NAME);
        getDriver().findElement(By.cssSelector("li[tabindex='0'][class='hudson_model_FreeStyleProject']")).click();
        getDriver().findElement(By.xpath("//button[@type='submit']")).click();
        getDriver().findElement(By.name("description")).sendKeys("This is a sample project.");
        WebElement submitButton = getDriver().findElement(By.xpath("//*[@id=\"yui-gen25-button\"]"));
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("arguments[0].click()", submitButton);
    }
    protected void deleteProject() {
        getDriver().findElement(By.cssSelector("img#jenkins-head-icon")).click();
        getDriver().findElement(By.xpath("//a[contains(@href, 'Some_Project')]")).click();
        getDriver().findElement(By.cssSelector("a[data-post='true']")).click();
        getDriver().switchTo().alert().accept();
    }

    @Test
    public void descriptionTest(){
        final String expectedText = "This is a sample project.";
        addDescription();
        //FluentWait<WebDriver> fluentWait = new FluentWait<>(getDriver()).withTimeout(10, TimeUnit.SECONDS).pollingEvery(200, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
        //WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/div[2]/div[1]/div[1]")));
        //new WebDriverWait(getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'This is a sample project.')]")));
        //String descriptionText = getDriver().findElement(By.xpath("//*[contains(text(), 'This is a sample project.')]")).getText();
        WebElement descrpText = getDriver().findElement(By.id("description"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();

        String actualText = (String) javascriptExecutor.executeScript("return arguments[0].value='This is a sample project.';", descrpText);
        System.out.println(actualText);
        //String actualText = getDriver().findElement(By.xpath("//*[contains(text(), 'This is a sample project.')]")).getText();
        Assert.assertEquals(actualText, expectedText);
        deleteProject();
    }
}
