package tests;

import org.testng.annotations.Test;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class PricingCalculatorPageTest extends AbstractTest {

    public GoogleCloudPricingCalculatorPage createPage() {
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(GOOGLE_CLOUD_START_PAGE);
        googleCloudStartPage.pageSearch(CALCULATOR_NAME);
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    @Test
    public void activateSectionTest() {
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = createPage();
        pricingCalculatorPage.switchFrame();
        pricingCalculatorPage.activateSection();
    }

    @Test
    public void fillFormTest() {
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

}
