package pageobjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.RegisterPageUI;

public class RegisterPage extends BasePage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextbox(WebDriver driver, String email) {
        waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
        sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
    }

    public void clickSubmitButton(WebDriver driver) {
        waitForElementClickable(driver, RegisterPageUI.SUBMIT_BUTTON);
        clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
    }

    public String getUserIdFromTableRow(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.USER_ID_ROW);
        return getElementText(driver, RegisterPageUI.USER_ID_ROW);
    }

    public String getPasswordFromTableRow(WebDriver driver) {
        waitForElementVisible(driver, RegisterPageUI.PASSWORD_ROW);
        return getElementText(driver, RegisterPageUI.PASSWORD_ROW);
    }

    public void openLoginPage(WebDriver driver, String url) {
        driver.navigate().to(url);
    }
}
