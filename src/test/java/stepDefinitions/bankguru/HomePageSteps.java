package stepDefinitions.bankguru;

import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageobjects.HomePage;
import pageobjects.PageGeneratorManager;

public class HomePageSteps {

    WebDriver driver;
    HomePage homePage;

    public HomePageSteps() {
        driver = Hooks.openAndQuitBrowser();
        homePage = PageGeneratorManager.getPageGeneratorManager().getHomePage(driver);
    }


    @Then("^Verify homepage is displayed with message \"([^\"]*)\"$")
    public void verifyHomepageIsDisplayedWithMessage(String message) {
        Assert.assertTrue(homePage.isHomePageHeadingDisplayed(driver, message));
    }
}
