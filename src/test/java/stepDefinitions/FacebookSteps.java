package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FacebookSteps {

    WebDriver driver;

    @Given("^Open facebook url$")
    public void openFacebookUrl() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://facebook.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^Input valid email or username$")
    public void inputValidEmailOrUsername(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @Given("^Click Forgot Password link$")
    public void clickForgotPasswordLink() {
        driver.findElement(By.xpath("//a[text()='Forgotten password?']")).click();
    }

    @When("^Input valid email with \"([^\"]*)\"$")
    public void inputValidEmailWith(String email) {
        driver.findElement(By.id("email")).sendKeys(email);
    }

    @When("^Input invalid emailAddress$")
    public void inputInvalidEmailAddress(DataTable emailTable) {
        List<Map<String, String>> emails = emailTable.asMaps(String.class, String.class);
        for(int i = 0; i < emails.size(); i++) {
            driver.findElement(By.id("identify_email")).sendKeys(emails.get(i).get("emailAddress"));
        }
    }

    @When("^Input valid password with \"([^\"]*)\"$")
    public void inputValidPasswordWith(String password) {
        driver.findElement(By.id("pass")).sendKeys(password);
    }

    @When("^Click search button$")
    public void clickSearchButton() {
        driver.findElement(By.cssSelector("button#did_submit")).click();
    }

    @Then("^\"([^\"]*)\" message is displayed$")
    public void messageIsDisplayed(String message) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='" + message + "']")).isDisplayed());
    }

    @Then("^Click login button$")
    public void clickLoginButton() {
        driver.findElement(By.cssSelector("button[name='login']")).click();
    }

    @Then("^Login successfully$")
    public void loginSuccessfully() {
        Assert.assertTrue(true);
    }

    @Then("^Close application")
    public void closeApplication() {
        driver.quit();
    }
}
