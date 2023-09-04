package tests;

import driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import util.TestListener;

import java.util.ArrayList;

@Listeners({TestListener.class})
public abstract class AbstractTest {
    protected WebDriver driver;

    public static final String GOOGLE_CLOUD_START_PAGE_URL = "https://cloud.google.com/";
    public static final String GOOGLE_CLOUD_CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";
    public static final String CALCULATOR_NAME = "Google Cloud Platform Pricing Calculator";
    public static final String DROPMAIL_START_PAGE_URL = "https://dropmail.me/ru/";

    @BeforeMethod(alwaysRun = true)
    protected void browserSetup() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    protected void closeDriver() {
        DriverSingleton.closeDriver();
    }

    protected void createNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
    }

    protected void switchToTab(int tabIndex) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(tabIndex));
    }
}