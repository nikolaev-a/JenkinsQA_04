package runner.pageObgects.homePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.BaseTest;

public class HomePageLocators extends BaseTest {

    public static WebElement LogOutBtn = getDriver().findElement(By.xpath("//a[@href='/logout']"));
}
