import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DreamTeamJavaGroupTest extends BaseTest {

    public static final String FOOTER_REST_API = "//div[@class='page-footer__links rest_api hidden-xs']";
    public static final String REST_API_PAGE = "http://localhost:8080/api/";

    @Test
    public void testFooterCheckLinksAPI() {

        getDriver().findElement(By.xpath(FOOTER_REST_API)).click();
        Assert.assertEquals(getDriver().getCurrentUrl(), REST_API_PAGE);
    }
}
