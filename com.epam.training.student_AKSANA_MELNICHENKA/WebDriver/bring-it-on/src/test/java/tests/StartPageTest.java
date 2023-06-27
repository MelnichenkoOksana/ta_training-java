package tests;

import org.testng.annotations.Test;
import pages.PastebinResultPage;
import pages.PastebinStartPage;

public class StartPageTest extends AbstractTest {
    public String newPasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    public String newTitleText = "how to gain dominance among developers";

    @Test
    public void pastebinStartPageTest() {
        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage(PASTEBIN_START_PAGE_URL);
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingSyntaxHighlightingField();
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
        PastebinResultPage pastebinResultPage = new PastebinResultPage(driver); //?
    }
}
