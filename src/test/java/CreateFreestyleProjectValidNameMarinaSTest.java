import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;


public class CreateFreestyleProjectValidNameMarinaSTest extends BaseTest {

    private final String FREESTYLE_PROJECT_NAME = "MarinaTest2";

    private void deleteProject(String name) {
        if (name != null && !name.equals("")) {
            getDriver()
                    .findElement(By.id("job_" + FREESTYLE_PROJECT_NAME))
                    .findElement(By.className("jenkins-table__link"))
                    .click();
            getDriver().findElement(By.xpath("//a[@data-url='/job/" + FREESTYLE_PROJECT_NAME + "/doDelete']"))
                    .click();
            getDriver().switchTo().alert().accept();
        }
    }

    @Test
    public void testCreateFreestyleProjectValidName() {

        getDriver().findElement(By.xpath("//div[@id='tasks']//a[@href='/view/all/newJob']")).click();
        getDriver().findElement(By.id("name")).sendKeys(FREESTYLE_PROJECT_NAME);
//        getDriver()
//                .findElement(By.id("j-add-item-type-standalone-projects"))
//                .findElement(By.xpath("//li[@class='hudson_model_FreeStyleProject']/label"))
//                .click();
//        getDriver().findElement(By.id("ok-button")).click();
//        getDriver().findElement(By.id("yui-gen25-button")).click();
//        getDriver().findElement(By.xpath("//ul[@id='breadcrumbs']//a[@href='/']")).click();
//
//        String actualResult = getDriver()
//                .findElement(By.id("job_" + FREESTYLE_PROJECT_NAME))
//                .findElement(By.className("jenkins-table__link"))
//                .getText();
//
//        Assert.assertEquals(actualResult, FREESTYLE_PROJECT_NAME);
//
//        deleteProject(FREESTYLE_PROJECT_NAME);
    }
}

