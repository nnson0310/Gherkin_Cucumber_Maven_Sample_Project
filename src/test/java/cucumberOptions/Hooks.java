package cucumberOptions;

import commons.GlobalConstants;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

import java.util.concurrent.TimeUnit;

public class Hooks {
    private static WebDriver driver;
    private static final Logger log = Logger.getLogger(Hooks.class.getName());

    @Before
    public static WebDriver openAndQuitBrowser() {
        // Run by Maven command line
        String browser = System.getProperty("BROWSER");
        System.out.println("Browser name run by command line = " + browser);

        if (driver == null) {
            try {
                if (browser == null) {
                    browser = "firefox";
                }
                switch (browser) {
                    case "h_chrome":
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        chromeOptions.addArguments("headless");
                        chromeOptions.addArguments("window-size=1920x1080");
                        driver = new ChromeDriver(chromeOptions);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        driver = new FirefoxDriver();
                        break;
                    case "h_firefox":
                        WebDriverManager.firefoxdriver().setup();
                        System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        firefoxOptions.setHeadless(true);
                        driver = new FirefoxDriver(firefoxOptions);
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    case "opera":
                        WebDriverManager.operadriver().setup();
                        driver = new OperaDriver();
                        break;
                    default:
                        WebDriverManager.chromedriver().setup();
                        driver = new ChromeDriver();
                        break;
                }
            }
            finally {
                //close browser and quit driver no matter happening
                Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
            }

            driver.get(GlobalConstants.getGlobalConstants().getMainAppUrl());
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        }
        return driver;
    }

    @After
    public static void close() {
        try {
            if (driver != null) {
                openAndQuitBrowser().quit();
                log.info("------------- Closed the browser -------------");
            }
        } catch (UnreachableBrowserException e) {
            log.info("------------- Can not close the browser -------------");
        }
    }

    private static class BrowserCleanup implements Runnable {
        @Override
        public void run() {
            close();
        }
    }
}
