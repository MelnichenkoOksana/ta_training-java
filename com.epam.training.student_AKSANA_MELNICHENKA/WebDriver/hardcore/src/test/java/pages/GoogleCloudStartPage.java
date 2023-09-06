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

    private final By labelSearchElement = By.xpath("//*[@name='q']");
    private final By labelLinkCalculator = By.xpath("//b[text() = 'Google Cloud Pricing Calculator']");

    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.visibilityOf(searchElement));
      return this;
    }

    public GoogleCloudPricingCalculatorPage pageSearch(String requestText) {
        searchElement.click();
        entryField.sendKeys(requestText);
        entryField.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelLinkCalculator));
        linkCalculator.click();

        return new GoogleCloudPricingCalculatorPage(driver);
    }

}