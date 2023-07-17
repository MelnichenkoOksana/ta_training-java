package tests;

import org.testng.annotations.Test;
import pages.DropmailStartPage;

public class DropmailStartPageTest extends AbstractTest {

    public String startPageURL = "https://dropmail.me/ru/";

    @Test
    public void startPageTest() {
        DropmailStartPage dropmailStartPage = new DropmailStartPage(driver);
        dropmailStartPage.openPage(startPageURL);
        String emailName = dropmailStartPage.getEmailName();
    }

}
