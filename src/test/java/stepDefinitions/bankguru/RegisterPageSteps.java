package stepDefinitions.bankguru;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageobjects.PageGeneratorManager;
import pageobjects.RegisterPage;

public class RegisterPageSteps {

    WebDriver driver;
    RegisterPage registerPage;

    public static String userId, password;

    public RegisterPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        registerPage = PageGeneratorManager.getPageGeneratorManager().getRegisterPage(driver);
    }

    @When("^Input email address with \"([^\"]*)\"$")
    public void inputEmailAddressWith(String email) {
        registerPage.inputToEmailTextbox(driver, email);
    }

    @When("^Click submit button$")
    public void clickSubmitButton() {
        registerPage.clickSubmitButton(driver);
    }

    @Then("^Get userId$")
    public void getUserId() {
        userId = registerPage.getUserIdFromTableRow(driver);
    }

    @Then("^Get password$")
    public void getPassword() {
        password = registerPage.getPasswordFromTableRow(driver);
    }

    @When("^Open login page$")
    public void openLoginPage() {
        registerPage.openLoginPage(driver, LoginPageSteps.loginPageUrl);
    }

}
