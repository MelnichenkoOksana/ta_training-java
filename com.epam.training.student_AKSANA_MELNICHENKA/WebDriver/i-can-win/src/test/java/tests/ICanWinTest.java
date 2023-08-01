package tests;

import org.testng.annotations.Test;
import pages.PastebinStartPage;

public class ICanWinTest extends AbstractTest {

    public String newPasteText = "Hello from WebDriver";
    public String newTitleText = "helloweb";

    @Test
    public void pastebinTest() {

        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage();
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
    }
}