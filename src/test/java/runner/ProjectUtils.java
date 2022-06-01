package runner;

import org.openqa.selenium.WebDriver;

import static runner.pageObgects.homePage.HomePageLocators.*;
import static runner.pageObgects.loginPage.LoginPageLocators.*;
import static runner.BaseUtils.PREFIX_PROP;
import static runner.BaseUtils.getProperties;

public final class ProjectUtils {

    private static final String PROP_PORT = PREFIX_PROP + "port";
    private static final String PROP_ADMIN_USERNAME = PREFIX_PROP + "admin.username";
    private static final String PROP_ADMIN_PAS = PREFIX_PROP + "admin.password";

    static void login(WebDriver driver) {
        driver.get(String.format("http://localhost:%s", getProperties().getProperty(PROP_PORT)));
        UserNameField.sendKeys(getProperties().getProperty(PROP_ADMIN_USERNAME));
        PasswordField.sendKeys(getProperties().getProperty(PROP_ADMIN_PAS));
        SignInBtn.click();
    }

    static void logout() {
        LogOutBtn.click();
    }
}
