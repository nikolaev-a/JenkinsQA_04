import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import runner.BaseTest;

import java.util.ArrayList;

public class DreamTeamJavaGroupTest extends BaseTest {

    public static final String FOOTER_REST_API = "//div[@class='page-footer__links rest_api hidden-xs']";
    public static final String REST_API_PAGE_HEADER = "//div[@id='main-panel']/h1";

    @Ignore
    @Test(enabled = false)
    public void testTC_132_001_FooterCheckLinksFelix_IX() {

        getDriver().findElement(By.xpath(FOOTER_REST_API)).click();
        Assert.assertEquals(getDriver().findElement(By.xpath(REST_API_PAGE_HEADER)).getText(), "REST API");
    }
/*
* Steps:
*go to the menu People
*click the icon with the size M
*click the icon with the size L
*click the icon with the size S
*
*Expected results:
*The size is 40px
*The size is 50px
*The size is 34px
* */
    @Test
    public void testTC_106_001_CheckFunctionalityIconsMariaShy() {
        getDriver().findElement(By.xpath("//div[@id='tasks']/div[2]/span/a")).click();

        getDriver().findElement(
                By.xpath("//*[@id='main-panel']/div[2]/div[1]/ol/li[2]/a")).click();
        WebElement sizeM = getDriver().findElement(
                By.xpath("//*[@id='person-admin']/td[4]"));
        Assert.assertEquals(sizeM.getSize().toString(), "(765, 40)");

        getDriver().findElement(
                By.xpath("//*[@id='main-panel']/div[2]/div[1]/ol/li[3]/a")).click();
        WebElement sizeL = getDriver().findElement(
                By.xpath("//*[@id='person-admin']/td[4]"));
        Assert.assertEquals(sizeL.getSize().toString(), "(745, 50)");

        getDriver().findElement(
                By.xpath("//*[@id='main-panel']/div[2]/div[1]/ol/li[1]")).click();
        WebElement sizeS = getDriver().findElement(
                By.xpath("//*[@id='person-admin']/td[4]"));
        Assert.assertEquals(sizeS.getSize().toString(), "(794, 34)");
    }

}
