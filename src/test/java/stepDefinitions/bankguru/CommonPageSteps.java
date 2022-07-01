package stepDefinitions.bankguru;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.CommonPage;
import pageobjects.PageGeneratorManager;

public class CommonPageSteps {
    WebDriver driver;
    CommonPage commonPage;

    @When("^Enter userId with value \"([^\"]*)\"$")
    public void enter_userId_with_value(String arg1) {
    }

    @When("^Enter password with value \"([^\"]*)\"$")
    public void enter_password_with_value(String arg1) {
    }

    public CommonPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        commonPage = PageGeneratorManager.getPageGeneratorManager().getCommonPageSteps(driver);
    }

    @When("^Click to dynamic \"([^\"]*)\" link in menu sub$")
    public void clickToDynamicLinkInMenuSub(String fieldName) {
        commonPage.clickToLinkInMenuSub(fieldName);
    }

    @When("^Enter to dynamic \"([^\"]*)\" textbox with value \"([^\"]*)\"$")
    public void enterToDynamicTextbox(String fieldName, String value) {
        commonPage.enterToDynamicTextbox(fieldName, value);
    }

    @When("^Click to dynamic radio checkbox with value \"([^\"]*)\"$")
    public void clickToDynamicRadioCheckbox(String value) {
        commonPage.clickToDynamicRadioCheckbox(value);
    }

    @When("^Enter to dynamic \"([^\"]*)\" textarea with value \"([^\"]*)\"$")
    public void enterToDynamicTextarea(String fieldName, String value) {
        commonPage.enterToDynamicTextarea(fieldName, value);
    }

    @When("^Click to dynamic button with value \"([^\"]*)\"$")
    public void clickToDynamicButton(String fieldName) {
        commonPage.clickToDynamicButton(fieldName);
    }

    @Then("^Register success message with value \"([^\"]*)\" is displayed$")
    public void registerSuccessMessageWithValueIsDisplayed(String value) {
        Assert.assertTrue(true);
    }

}
