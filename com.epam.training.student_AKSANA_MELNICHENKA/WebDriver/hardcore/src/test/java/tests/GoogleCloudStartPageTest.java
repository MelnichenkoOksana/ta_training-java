package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleCloudStartPage;

public class GoogleCloudStartPageTest {
    public WebDriver driver = new ChromeDriver();
    public String startPageURL = "https://cloud.google.com/";

    public String calculatorName = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void startPageTest(){
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(startPageURL);
        googleCloudStartPage.pageSearch(calculatorName);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }

}
