package tests;

import org.testng.annotations.Test;
import pages.DropmailStartPage;
import pages.EstimatedCostPage;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class EstimatedCostPageTest extends AbstractTest {

    public EstimatedCostPage openPage(String startPageURL) {
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(startPageURL);
        googleCloudStartPage.pageSearch(CALCULATOR_NAME);
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
    public void chekDataTest() {
        EstimatedCostPage estimatedCostPage = openPage(GOOGLE_CLOUD_START_PAGE);
        estimatedCostPage.pressButtonEmailEstimate();
        createNewTab();
        switchToTab(1);
        DropmailStartPage dropmailStartPage = new DropmailStartPage(driver);
        dropmailStartPage.openPage(DROPMAIL_START_PAGE);
        String emailName = dropmailStartPage.getEmailName();
        switchToTab(0);
        estimatedCostPage.switchFrame();
        estimatedCostPage.fillFieldEmail(emailName);
        estimatedCostPage.pressButtonSendEmail();
        switchToTab(1);
        dropmailStartPage.pressHTMLButton();
        dropmailStartPage.switchFrame();

        assert dropmailStartPage.checkTotalEstimatedCost("USD 4,024.56");

    }

}