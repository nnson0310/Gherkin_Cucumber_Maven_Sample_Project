package pageobjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageinterfaces.CommonPageUI;

public class CommonPage extends BasePage {

    WebDriver driver;

    public CommonPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToLinkInMenuSub(String menuName) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_MENU_SUB_LINK, menuName);
        clickToElement(driver, CommonPageUI.DYNAMIC_MENU_SUB_LINK, menuName);
    }

    public void enterToDynamicTextbox(String fieldName, String value) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_FORM_TEXTBOX, fieldName);
        if (getAttributeValue(driver, CommonPageUI.DYNAMIC_FORM_TEXTBOX, "type", fieldName) != "date") {
            removeAttributeInDOM(driver, CommonPageUI.DYNAMIC_FORM_TEXTBOX, "type", fieldName);
        }
        sendKeyToElement(driver, CommonPageUI.DYNAMIC_FORM_TEXTBOX, value, fieldName);
    }

    public void clickToDynamicRadioCheckbox(String value) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_FORM_RADIO, value);
        clickToElement(driver, CommonPageUI.DYNAMIC_FORM_RADIO, value);
    }

    public void enterToDynamicTextarea(String fieldName, String value) {
        waitForElementVisible(driver, CommonPageUI.DYNAMIC_FORM_TEXTAREA, fieldName);
        sendKeyToElement(driver, CommonPageUI.DYNAMIC_FORM_TEXTAREA, value, fieldName);
    }

    public void clickToDynamicButton(String fieldName) {
        waitForElementClickable(driver, CommonPageUI.DYNAMIC_FORM_BUTTON, fieldName);
        clickToElement(driver, CommonPageUI.DYNAMIC_FORM_BUTTON, fieldName);
    }
}
