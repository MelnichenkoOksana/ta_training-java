package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class PricingCalculatorPageTest {
    public WebDriver driver = new ChromeDriver();
    public String startPageURL = "https://cloud.google.com/";

    public String calculatorName = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    public GoogleCloudPricingCalculatorPage createPage(){
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(startPageURL);
        googleCloudStartPage.pageSearch(calculatorName);
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    @Test
    public void activateSectionTest(){
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = createPage();
        pricingCalculatorPage.switchFrame();
        pricingCalculatorPage.activateSection();
    }

    @Test
    public void fillFormTest(){
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = createPage();
        pricingCalculatorPage.switchFrame();
        pricingCalculatorPage.fillFieldNumberInstances();
        pricingCalculatorPage.fillFieldOperatingSystem();
        pricingCalculatorPage.fillFieldVMClass();
        pricingCalculatorPage.fillFieldSeries();
        pricingCalculatorPage.fillFieldMachineType();
        pricingCalculatorPage.choiceAddGPUs();
        pricingCalculatorPage.fillGPUType();
        pricingCalculatorPage.fillNumberOfGPUs();
        pricingCalculatorPage.fillLocalSSD();
        pricingCalculatorPage.fillDatacenterLocation();
        pricingCalculatorPage.fillCommitUsage();

        pricingCalculatorPage.createEstimate();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }

}
