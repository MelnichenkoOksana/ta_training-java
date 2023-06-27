package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.EstimatedCostPage;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class EstimatedCostPageTest {

    public WebDriver driver = new ChromeDriver();
    public String startPageURL = "https://cloud.google.com/";

    public String calculatorName = "Google Cloud Platform Pricing Calculator";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }


    public EstimatedCostPage openPage(String startPageURL){
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(startPageURL);
        googleCloudStartPage.pageSearch(calculatorName);
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new GoogleCloudPricingCalculatorPage(driver);

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

        return new EstimatedCostPage(driver);
    }

    @Test
    public void chekDataTest(){
        EstimatedCostPage estimatedCostPage = openPage(startPageURL);

        estimatedCostPage.pressButtonEmailEstimate();
        estimatedCostPage.switchToFrame();
//        estimatedCostPage.fillEmail();
    }

//    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }

}