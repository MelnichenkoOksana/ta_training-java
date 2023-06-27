package tests;

import org.testng.annotations.Test;
import pages.EstimatedCostPage;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class EstimatedCostPageTest extends AbstractTest {

    public EstimatedCostPage openPage(String startPageURL) {
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(startPageURL).pageSearch(CALCULATOR_NAME);
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
    public void checkDataTest() {
        EstimatedCostPage estimatedCostPage = openPage(GOOGLE_CLOUD_START_PAGE);

        assert estimatedCostPage.getVMClass().contains("Regular");

        assert estimatedCostPage.checkInstanceType("n1-standard-8");
        assert estimatedCostPage.checkRegion("Frankfurt");
        assert estimatedCostPage.checkLocalSSD("2x375 GiB");
        assert estimatedCostPage.checkCommitmentTerm("1 Year");

        assert estimatedCostPage.checkTotalEstimatedCost("USD 4,024.56 per 1 month");
    }

}
