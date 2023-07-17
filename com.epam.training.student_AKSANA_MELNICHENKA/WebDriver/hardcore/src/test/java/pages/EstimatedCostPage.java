package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class EstimatedCostPage extends AbstractPage {

    public String startPageURL = "https://dropmail.me/ru/";

    public EstimatedCostPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonEmailEstimate() {
        WebElement buttonEmailEstimate = driver.findElement(By.xpath("//button[@title='Email Estimate']/span"));
        buttonEmailEstimate.click();
    }

    public String getEmailName() {
        DropmailStartPage dropmailStartPage = new DropmailStartPage(driver);
        dropmailStartPage.openPage(startPageURL);
        return dropmailStartPage.getEmailName();
    }

    public void fillEmail() {
        WebElement fieldEmail = driver.findElement(By.xpath("//md-input-container/child::input[@ng-model='emailQuote.user.email']"));
        fieldEmail.click();
        fieldEmail.sendKeys(getEmailName());
    }
}
