package stepDefinitions.bankguru;

import commons.GlobalConstants;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import org.openqa.selenium.WebDriver;
import pageobjects.LoginPage;
import pageobjects.PageGeneratorManager;

public class LoginPageSteps {

    WebDriver driver;
    LoginPage loginPage;
//    private String userId = "mngr421526";
//    private String password = "urEpuzU";
    public static String loginPageUrl;

    public LoginPageSteps() {
        driver = Hooks.openAndQuitBrowser();
        loginPage = PageGeneratorManager.getPageGeneratorManager().getLoginPage(driver);
        loginPageUrl = GlobalConstants.getGlobalConstants().getMainAppUrl();
    }

    @When("^Click register link$")
    public void clickRegisterLink() {
        loginPage.clickRegisterLink(driver);
    }

    @When("^Input userid$")
    public void inputUserid() {
//        loginPage.inputToUserIdTextbox(driver, RegisterPageSteps.userId);
//          loginPage.inputToUserIdTextbox(driver, userId);
        loginPage.inputToUserIdTextbox(driver, (String) ContextInit.getClassContext().getContext(Context.USER_ID));
    }

    @When("^Input password$")
    public void inputPassword() {
//        loginPage.inputToPasswordTextbox(driver, RegisterPageSteps.password);
        loginPage.inputToPasswordTextbox(driver, (String) ContextInit.getClassContext().getContext(Context.PASSWORD));
    }

    @And("^Click login button$")
    public void clickLoginButton() {
        loginPage.clickToLoginButton(driver);
    }
}
