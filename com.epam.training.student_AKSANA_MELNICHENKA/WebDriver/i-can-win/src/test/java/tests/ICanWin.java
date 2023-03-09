package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PastebinStartPage;

public class ICanWin {
    public WebDriver driver = new ChromeDriver();
    public String newPasteText = "Hello from WebDriver";
    public String newTitleText = "helloweb";

    @Test
    public void pastebinTest(){
        PastebinStartPage pastebinStartPage = new PastebinStartPage(driver);
        pastebinStartPage.openPage();
        pastebinStartPage.fillingNewPasteField(newPasteText);
        pastebinStartPage.fillingPasteExpirationField();
        pastebinStartPage.fillingTitleField(newTitleText);
        pastebinStartPage.clickButtonCreateNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
    }
}
