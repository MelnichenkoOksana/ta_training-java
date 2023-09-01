package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EstimatedCostPage extends AbstractPage {

    @FindBy(xpath = "//button[@title='Email Estimate']/span")
    private WebElement buttonEmailEstimate;

    @FindBy(xpath = "//md-input-container/child::input[@ng-model='emailQuote.user.email']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//button[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement buttonSendEmail;

    public EstimatedCostPage(WebDriver driver) {
        super(driver);
    }

    public void pressButtonEmailEstimate() {
        buttonEmailEstimate.click();
    }

    public void fillFieldEmail(String email) {
        fieldEmail.click();
        fieldEmail.sendKeys(email);
    }

    public void pressButtonSendEmail() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        executor.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'})", buttonSendEmail);
        buttonSendEmail.click();
    }
}
