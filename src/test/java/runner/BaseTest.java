package runner;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {

    private static WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        ProjectUtils.login(driver);
    }

    @AfterMethod
    protected void afterMethod() {
        ProjectUtils.logout();
        driver.quit();
    }

    protected static WebDriver getDriver() {
        return driver;
    }
}
