import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.List;

public class DisableOrganizationFolderTest extends BaseTest {

    final String VALID_VALUE_FOR_NAME = "New organization folder";

    private void preconditionCreateOrganizationFolder(){
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(VALID_VALUE_FOR_NAME);
        getDriver().findElement(By.className("jenkins_branch_OrganizationFolder")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen17-button")).click();
        getDriver().findElement(By.linkText("Dashboard")).click();
    }
    private void postconditionDeleteFolderAfterTest(){
        getDriver().findElement(By.linkText("" + VALID_VALUE_FOR_NAME + "")).click();
        getDriver().findElement(By.linkText("Delete Organization Folder")).click();
        getDriver().findElement(By.id("yui-gen1-button")).click();
    }

    @Test
    public void testDisableOrganizationFolder() {
        preconditionCreateOrganizationFolder();
        List<WebElement> tableOnDashboard =
                getDriver().findElements(By.xpath("//table[@id='projectstatus']/tbody/tr/td/a"));
        for (WebElement item : tableOnDashboard){
            if (item.getText().contains(VALID_VALUE_FOR_NAME)) {
                item.click();
            }
        }
        getDriver().findElement(By.id("yui-gen1-button")).click();
        String expectedWarning = "This Organization Folder is currently disabled \nEnable";
        WebElement actualWarning = getDriver().findElement(By.id("enable-project"));
        Assert.assertEquals(actualWarning.getText(), expectedWarning);
        WebElement disabledIcon = getDriver().findElement(By.xpath("//img[@class = 'icon-folder-disabled icon-xlg']"));
        Assert.assertTrue(disabledIcon.isDisplayed());
        postconditionDeleteFolderAfterTest();
    }
}
