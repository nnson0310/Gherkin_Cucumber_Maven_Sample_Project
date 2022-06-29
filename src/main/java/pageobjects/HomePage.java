package pageobjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.HomePageUI;

public class HomePage extends BasePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isHomePageHeadingDisplayed(WebDriver driver, String message) {
        waitForElementVisible(driver, HomePageUI.HOME_PAGE_HEADING);
        return isElementDisplayed(driver,  HomePageUI.HOME_PAGE_HEADING);
    }
}
