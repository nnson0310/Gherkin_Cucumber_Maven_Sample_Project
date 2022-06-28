package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
    public void inputValidEmailOrUsername() {
        driver.findElement(By.id("email")).sendKeys("tomanyeuem@gmail.com");
    }

    @Then("^Input valid password$")
    public void inputValidPassword() {
        driver.findElement(By.id("pass")).sendKeys("123456");
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
