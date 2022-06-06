import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DeletePipelineDescriptionTest extends BaseTest {

    @Test
    public void deletePipelineDescriptionTest() {
        WebElement piplineLink = getDriver().findElement(By.xpath("//*[@id=\"job_test\"]/td[3]/a"));
        piplineLink.click();

        WebElement changeDescriptionButton = getDriver().findElement(By.id("description-link"));
        changeDescriptionButton.click();
        WebElement descriptionField = getDriver().findElement(By.xpath("//textarea[@name=\"description\"]"));
        descriptionField.clear();
        WebElement saveDescriptionButton = getDriver().findElement(By.id("yui-gen2-button"));
        saveDescriptionButton.click();

        WebElement descriptionValue = getDriver().findElement(By.xpath("//*[@id=\"description\"]/div[1]"));
        Assert.assertEquals(descriptionValue.getText(), "");
    }
}
