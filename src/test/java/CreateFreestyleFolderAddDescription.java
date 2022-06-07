import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import runner.BaseTest;

public class CreateFreestyleFolderAddDescription extends BaseTest {

    private void deleteNewFolder(String link) {
        getDriver().findElement(By.linkText(link)).click();
        getDriver().findElement(By.linkText("Delete Folder")).click();
        getDriver().findElement(By.id("yui-gen1-button")).click();
    }

    private void deleteNewProject(String link) {
        getDriver().findElement(By.linkText(link)).click();
        getDriver().findElement(By.linkText("Delete Project")).click();

        getDriver().switchTo().alert().accept();
    }

    private void createNewFolder(String name) {
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys(name);
        getDriver().findElement(By.xpath("//div[@id='j-add-item-type-nested-projects']//li[1]")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen6-button")).click();
    }

    private void clearDescriptionBoxOfFreestyleProject() {
        getDriver().findElement(By.id("description-link")).click();
        if (getDriver().findElement(By.name(("description"))).isDisplayed()) {
            getDriver().findElement(By.name("description")).clear();
            getDriver().findElement(By.id("yui-gen1-button")).click();
        }
    }

    @Test
    public void createFreestyleProject() {
        getDriver().findElement(By.linkText("New Item")).click();
        getDriver().findElement(By.id("name")).sendKeys("project 10");
        getDriver().findElement(By.xpath("//div[@id='j-add-item-type-standalone-projects']/ul//li[1]")).click();
        getDriver().findElement(By.id("ok-button")).click();

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        getDriver().findElement(By.xpath("//button[@type='submit']")).click();

        Assert.assertEquals(getDriver().getTitle(), "project 10 [Jenkins]");

        deleteNewProject("project 10");
    }

    @Test
    public void testAddDescriptionToFreestyleProject() {
        getDriver().findElement(By.xpath("//a[@href='editDescription']")).click();
        getDriver().findElement(By.xpath("//textarea[@name='description']")).sendKeys("new description added");

        getDriver().findElement(By.id("yui-gen1-button")).click();

        Assert.assertEquals(getDriver().findElement(
                By.xpath("//div[@id='description']/div[text()]")).getText(), "new description added");

        clearDescriptionBoxOfFreestyleProject();
    }
}

