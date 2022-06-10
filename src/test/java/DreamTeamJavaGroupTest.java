import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DreamTeamJavaGroupTest extends BaseTest {

    public static final String FOOTER_REST_API = "//div[@class='page-footer__links rest_api hidden-xs']";
    public static final String REST_API_PAGE_HEADER = "//div[@id='main-panel']/h1";
    public static final String ITEMNAME = "Valid item name" + (int) (Math.random() * 1000);

    @Ignore
    @Test(enabled = false)
    public void testTC_132_001_FooterCheckLinksFelix_IX() {

        getDriver().findElement(By.xpath(FOOTER_REST_API)).click();
        Assert.assertEquals(getDriver().findElement(By.xpath(REST_API_PAGE_HEADER)).getText(), "REST API");
    }

    @Test
    public void testTC_001_037_CreateNewFreestyleProject_AD() {
        getDriver().findElement(By.className("task-link-text")).click();
        getDriver().findElement(By.id("name")).sendKeys(ITEMNAME);
        getDriver().findElement(By.className("hudson_model_FreeStyleProject")).click();
        getDriver().findElement(By.id("ok-button")).click();
        getDriver().findElement(By.id("yui-gen19-button")).click();
        getDriver().findElement(By.id("yui-gen25-button")).click();
        getDriver().findElement(By.xpath("//a[text()='Dashboard']")).click();
        String temp = getDriver().findElement(By.id("job_" + ITEMNAME)).getText();
        Assert.assertTrue(temp.contains(ITEMNAME));
    }
}
