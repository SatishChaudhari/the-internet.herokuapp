package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url) {

        switch (browser) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "ChromeOptions": //Chrome Headless Browser
                WebDriverManager.chromiumdriver().setup();
                driver = new ChromeDriver(getChromeOptions());
                break;
            case "FirefoxOptions": // Firefox Headless Browser
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver(getFirefoxOptions());
                break;

        }
        goHome(url);
        homePage = new HomePage(driver);
      //  driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

    @BeforeMethod
    @Parameters("url")
    public void goHome(String url) {
        driver.get(url);
        homePage = new HomePage(driver);

    }

    @AfterMethod
    public void recordFailure(ITestResult result) {

        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {

                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public WindowManager getWindowManager() {

        return new WindowManager(driver);
    }

    /**
     * Using Options for setup a headless browser
     *
     * @return options
     */

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        return options;
    }

    private FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);
        return options;
    }

}
