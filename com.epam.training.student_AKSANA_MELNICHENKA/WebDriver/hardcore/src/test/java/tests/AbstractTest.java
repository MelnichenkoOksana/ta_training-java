package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.ArrayList;

public abstract class AbstractTest {
    protected WebDriver driver;

    public static final String GOOGLE_CLOUD_START_PAGE = "https://cloud.google.com/";
    public static final String CALCULATOR_NAME = "Google Cloud Platform Pricing Calculator";
    public static final String DROPMAIL_START_PAGE = "https://dropmail.me/ru/";


    @BeforeMethod(alwaysRun = true)
    protected void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    protected void closeDriver() {
        driver.quit();
    }

    protected void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    protected void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }
}