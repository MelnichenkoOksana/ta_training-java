package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PastebinResultPage;
import pages.PastebinStartPage;

import static org.testng.Assert.assertEquals;

public class BringItOn {
    public WebDriver driver;
    public String startPageURL = "https://pastebin.com";
    public String newPasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    public String newTitleText = "how to gain dominance among developers";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    private PastebinResultPage createPage (){
        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage(startPageURL);
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingSyntaxHighlightingField();
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
        return new PastebinResultPage(driver);
    }

    @Test
    public void pastebinResultPageTittleTest(){
        String titleText = createPage().getPageTittle();
        assertEquals(titleText,newTitleText);
    }

    @Test
    public void pastebinResultPageMatchesTest(){
        String pasteText = createPage().getCodeMatches();
        assertEquals(pasteText,newPasteText);
    }

    @Test
    public void pastebinResultPageSyntaxTest(){
        String syntax = createPage().getSyntaxHighlighting();
        assertEquals(syntax,"Bash");
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver = null;
    }
}
