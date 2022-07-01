package stepDefinitions.bankguru;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageobjects.PageGeneratorManager;
import pageobjects.RegisterPage;

// There are two ways to share data between scenarios in cucumber BDD
// Method 1: Using static variables
// Method 2: Using java libraries (likes Cucumber Picocontainer...)
public class RegisterPageSteps {

    WebDriver driver;
    RegisterPage registerPage;

//    public static String userId, password;

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
        String userId = registerPage.getUserIdFromTableRow(driver);
        ContextInit.getClassContext().setContext(Context.USER_ID, userId);
    }

    @Then("^Get password$")
    public void getPassword() {
        String password = registerPage.getPasswordFromTableRow(driver);
        ContextInit.getClassContext().setContext(Context.PASSWORD, password);
    }

    @When("^Open login page$")
    public void openLoginPage() {
        registerPage.openLoginPage(driver, LoginPageSteps.loginPageUrl);
    }

}
