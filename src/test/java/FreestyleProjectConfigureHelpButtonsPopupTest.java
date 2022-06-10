import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import runner.BaseTest;

import javax.swing.*;

public class FreestyleProjectConfigureHelpButtonsPopupTest extends BaseTest {
    private static final String PROJECT_NAME = "Freestyle project";


    private void createFreestyleProject() {
        getDriver().findElement(By.cssSelector("[title='New Item']")).click();
        getDriver().findElement(By.id("name")).sendKeys(PROJECT_NAME);
        getDriver().findElement(By.xpath("//span[text()='Freestyle project']")).click();
        getDriver().findElement(By.id("ok-button")).click();
//        getDriver().findElement(By.cssSelector("[name='description']"))
//                .sendKeys("This is a description for a Freestyle project");
        getDriver().findElement(By.xpath("//a[text()='Dashboard']")).click();
    }

    private void openProjectGeneralTab() {
        getDriver().findElement(By.xpath(String.format("//a[text()='%s']", PROJECT_NAME))).click();
        getDriver().findElement(By.xpath("//span[text()='Configure']")).click();
        getDriver().findElement(By.xpath("//div[contains(@class, 'active') and text()='General']")).click();
    }

    @Test
    public void testHelpButtonGeneralTabDiscardOldBuildsPopup() throws InterruptedException {
        Actions action = new Actions(getDriver());
        createFreestyleProject();
        openProjectGeneralTab();
        WebElement webElement = getDriver().findElement(By.cssSelector(".jenkins-help-button[tooltip='Help for feature: Discard old builds']"));
        //WebElement webElement = getDriver().findElement(By.cssSelector("[title='Help for feature: Discard old builds'"));
        //webElement.click();
        action.moveToElement(webElement).perform();
        //action.build();
        //action.perform();
        Thread.sleep(3000);
        WebElement element = getDriver().findElement(By.xpath("//div[text()='Help for feature: Discard old builds']"));

        System.out.println("************************************");
        System.out.println(webElement.getText());
        System.out.println("*****************************");
    }
}
