package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropmailStartPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='address']")
    private WebElement emailName;

    @FindBy(xpath = "//*[@class = 'bi-image']")
    private WebElement htmlButton;

    @FindBy(xpath = "//iframe[@class = 'mail-clean-html']")
    private WebElement frame;

    @FindBy(xpath = "//td//h2")
    private WebElement value;

    private final By labelEmailName = By.xpath("//span[@class='address']");
    private final By labelHTMLButton = By.xpath("//*[@class = 'bi-image']");
    private final By labelFrame = By.xpath("//iframe[@class = 'mail-clean-html']");

    public DropmailStartPage(WebDriver driver) {
        super(driver);
    }

    public DropmailStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        return this;
    }

    public String getEmailName() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelEmailName));
        return emailName.getText();
    }

    public void pressHTMLButton() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelHTMLButton));
        htmlButton.click();
    }

    public void switchFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelFrame));
        driver.switchTo().frame(frame);
    }

    public boolean checkTotalEstimatedCost(String expectedValue) {
        String actualValue = value.getText();
        return actualValue.contains(expectedValue);
    }

}
