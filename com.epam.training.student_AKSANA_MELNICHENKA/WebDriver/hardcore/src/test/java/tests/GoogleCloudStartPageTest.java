package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleCloudPricingCalculatorPage;
import pages.GoogleCloudStartPage;

public class GoogleCloudStartPageTest extends AbstractTest {

    @Test
    public void openCalculatorPageTest() {
        GoogleCloudPricingCalculatorPage pricingCalculatorPage = new GoogleCloudStartPage(driver)
                .openPage(GOOGLE_CLOUD_START_PAGE_URL)
                .pageSearch(CALCULATOR_NAME);

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, GOOGLE_CLOUD_CALCULATOR_PAGE_URL);
    }
}
