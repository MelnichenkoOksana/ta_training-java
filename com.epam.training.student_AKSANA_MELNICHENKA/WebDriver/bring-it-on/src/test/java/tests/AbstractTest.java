package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class AbstractTest {
    protected WebDriver driver;

    public static final String PASTEBIN_START_PAGE_URL = "https://pastebin.com";

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
}
