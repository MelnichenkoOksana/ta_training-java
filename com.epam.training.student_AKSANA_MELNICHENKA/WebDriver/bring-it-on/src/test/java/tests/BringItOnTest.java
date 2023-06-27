package tests;


import org.testng.annotations.Test;
import pages.PastebinStartPage;
import pages.PastebinResultPage;

import static org.testng.Assert.assertEquals;


public class BringItOnTest extends AbstractTest {

    public String newPasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    public String newTitleText = "how to gain dominance among developers";


    @Test
    public void pastebinResultPageTittleTest() {
        String titleText = createPage().getPageTittle();
        assertEquals(titleText, newTitleText);
    }

    @Test
    public void pastebinResultPageMatchesTest() {
        String pasteText = createPage().getCodeMatches();
        assertEquals(pasteText, newPasteText);
    }

    @Test
    public void pastebinResultPageSyntaxTest() {
        String syntax = createPage().getSyntaxHighlighting();
        assertEquals(syntax, "Bash");
    }

    private PastebinResultPage createPage() {
        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage(PASTEBIN_START_PAGE_URL);
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingSyntaxHighlightingField();
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
        return new PastebinResultPage(driver);
    }

}
