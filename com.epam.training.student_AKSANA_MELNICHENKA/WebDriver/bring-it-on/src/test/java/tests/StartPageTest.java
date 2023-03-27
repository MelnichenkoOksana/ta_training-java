package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PastebinResultPage;
import pages.PastebinStartPage;

public class StartPageTest {
    public WebDriver driver = new ChromeDriver();
    public String startPageURL = "https://pastebin.com";
    public String newPasteText = "git config --global user.name  \"New Sheriff in Town\"\n" +
                                    "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                    "git push origin master --force";
    public String newTitleText = "how to gain dominance among developers";


    @Test
    public void pastebinStartPageTest(){
        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage(startPageURL);
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingSyntaxHighlightingField();
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
        PastebinResultPage pastebinResultPage = new PastebinResultPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }
}
