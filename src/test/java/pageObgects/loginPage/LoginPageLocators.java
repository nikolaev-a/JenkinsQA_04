package pageObgects.loginPage;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import runner.BaseTest;



public class LoginPageLocators extends BaseTest{
   public static WebElement UserNameField = getDriver().findElement(By.name("j_username"));
   public static WebElement PasswordField = getDriver().findElement(By.name("j_password"));
   public static WebElement SignInBtn = getDriver().findElement(By.name("Submit"));


}
