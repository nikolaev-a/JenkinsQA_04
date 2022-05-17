import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import runner.BaseTest;

public class DmitriyTwoTest extends BaseTest {

    @Test
    public void testDmitriyRudoi () throws InterruptedException {
        getDriver().get("https://www.nord.com/ua/home-ua.jsp");
        Thread.sleep(2000);

        WebElement searchButton =
                getDriver().findElement(By.id("dropdown"));//"//*[@id=\"pl-navbar__main\"]/ul[1]/li[5]"));
        Thread.sleep(1000);
        searchButton.click();
        WebElement searchBox = getDriver().findElement(By.name("q"));
        searchBox.sendKeys("g1050");
        WebElement goButton =
                getDriver().findElement(By.xpath("//*[@id=\"pl-navbar__main\"]/ul[1]/li[5]/ul/form/button"));
        Thread.sleep(1000);
        goButton.click();


        String main =
                getDriver().findElement(By.xpath("//*[@id=\"main\"]/div/div/div[1]/h1")).getText();
        Assert.assertEquals(main, "Search results");
        getDriver().close();


    }

}
