import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import runner.BaseTest;

public class TatianaP_Jenkins_Test extends BaseTest {

    private void deleteNewFolder() {
        getDriver().findElement(By.linkText("Delete Folder")).click();
        getDriver().findElement(By.id("yui-gen1-button")).click();
    }

    private void createNewFolder(String name) {
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(name);
        getDriver().findElement(By.xpath("//div[@id='j-add-item-type-nested-projects']//li[1]")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen6-button")).click();
    }

    private void clearDescriptionBoxOfFreestyleProject(String url) {
        getDriver().get(url);
        getDriver().findElement(By.id("description-link")).click();
        getDriver().findElement(By.name("description")).clear();
        getDriver().findElement(By.id("yui-gen1-button")).click();
    }

    @Test
    public void testAddDescriptionToFreestyleProject(){
        getDriver().get("http://localhost:8080/job/Freestyle%20Project/");
        getDriver().findElement(By.linkText("Freestyle Project")).click();
        getDriver().findElement(By.id("description-link")).click();
        getDriver().findElement(By.name("description")).sendKeys("new description added");
        getDriver().findElement(By.id("yui-gen1-button")).click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//div[@id='description']/div[text()]")).getText(), "new description added");

        clearDescriptionBoxOfFreestyleProject("http://localhost:8080/job/Freestyle%20Project/");
    }
}

