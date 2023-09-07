package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropmailStartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='address']")
    private WebElement emailName;

    @FindBy(xpath = "//*[@class = 'bi-image']")
    private WebElement htmlButton;

    @FindBy(xpath = "//iframe[@class = 'mail-clean-html']")
    private WebElement frame;

    @FindBy(xpath = "//td//h2")
    private WebElement value;

    public DropmailStartPage(WebDriver driver) {
        super(driver);
    }

    public DropmailStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        return this;
    }

    public String getEmailName() {
        return waitElement(emailName).getText();
    }

    public void pressHTMLButton() {
        waitElement(htmlButton).click();
    }

    public void switchFrame() {
        waitElement(frame);
        driver.switchTo().frame(frame);
    }

    public String getTotalEstimatedCost() {
       return value.getText();
    }

}
