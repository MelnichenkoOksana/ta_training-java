package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudStartPage extends AbstractPage {

    @FindBy(xpath = "//*[@name='q']")
    private WebElement searchElement;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement entryField;

    @FindBy(xpath = "//b[text() = 'Google Cloud Pricing Calculator']")
    private WebElement linkCalculator;

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        waitElement(searchElement);
        return this;
    }

    public GoogleCloudPricingCalculatorPage pageSearch(String requestText) {
        searchElement.click();
        entryField.sendKeys(requestText);
        entryField.sendKeys(Keys.ENTER);
        waitElement(linkCalculator).click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }

}