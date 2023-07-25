package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

    public void fillFieldEmail(String email) {
        WebElement fieldEmail = driver.findElement(By.xpath("//md-input-container/child::input[@ng-model='emailQuote.user.email']"));
        fieldEmail.click();
        fieldEmail.sendKeys(email);
    }

    public void pressButtonSendEmail() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement buttonSendEmail = driver.findElement(By.xpath("//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']"));

        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", buttonSendEmail);
        buttonSendEmail.click();
    }
}
