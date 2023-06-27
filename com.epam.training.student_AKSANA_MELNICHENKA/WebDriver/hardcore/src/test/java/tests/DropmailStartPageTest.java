package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DropmailStartPage;

public class DropmailStartPageTest {
    public WebDriver driver = new ChromeDriver();
    public String startPageURL = "https://dropmail.me/ru/";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){
        driver = new ChromeDriver();
    }

    @Test
    public void startPageTest(){
        DropmailStartPage yopmailStartPage = new DropmailStartPage(driver);
        yopmailStartPage.openPage(startPageURL);
        String emailName = yopmailStartPage.getEmailName();
    }

//    @AfterMethod(alwaysRun = true)
    public void closeDriver(){
        driver.quit();
        driver=null;
    }


}
