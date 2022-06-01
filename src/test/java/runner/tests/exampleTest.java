package runner.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

import static runner.pageObgects.homePage.HomePageLocators.LogOutBtn;


public class exampleTest extends BaseTest {

    @Test
    public void testFirst() {
        Assert.assertTrue(LogOutBtn.isDisplayed());
    }

}
