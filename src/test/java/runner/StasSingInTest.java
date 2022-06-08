package runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StasSingInTest extends BaseTest {

    private WebDriver driver;

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }

    @Test
    public void testSignIn() {

        driver.get("http://localhost:8080");

        driver.findElement(By.name("j_username")).sendKeys("Some admin");
        driver.findElement(By.name("j_password")).sendKeys("Some password");
        driver.findElement(By.name("Submit")).click();

        String actualResult = driver.findElement(By.cssSelector(".alert.alert-danger")).getText();
        Assert.assertEquals(driver.getCurrentUrl(), "http://localhost:8080/loginError");
        Assert.assertEquals(actualResult, "Invalid username or password");
    }
}
