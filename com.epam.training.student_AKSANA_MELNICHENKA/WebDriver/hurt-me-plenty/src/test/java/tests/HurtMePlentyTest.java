package tests;

import org.testng.annotations.Test;
import pages.GoogleCloudStartPage;

public class HurtMePlentyTest extends AbstractTest {

    @Test
    public void startPageTest() {
        GoogleCloudStartPage googleCloudStartPage = new GoogleCloudStartPage(driver);
        googleCloudStartPage.openPage(GOOGLE_CLOUD_START_PAGE);
        googleCloudStartPage.pageSearch(CALCULATOR_NAME);

    }

}