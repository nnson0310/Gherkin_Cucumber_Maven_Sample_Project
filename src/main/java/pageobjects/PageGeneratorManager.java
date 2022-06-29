package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

    private static PageGeneratorManager pageGeneratorManager;

    private PageGeneratorManager() {

    }

    public static PageGeneratorManager getPageGeneratorManager() {
        if (pageGeneratorManager == null) {
            return new PageGeneratorManager();
        }
        return pageGeneratorManager;
    }

    public RegisterPage getRegisterPage(WebDriver driver) {
        return new RegisterPage(driver);
    }

    public HomePage getHomePage(WebDriver driver) {
        return new HomePage(driver);
    }

    public LoginPage getLoginPage(WebDriver driver) {
        return new LoginPage(driver);
    }

}
