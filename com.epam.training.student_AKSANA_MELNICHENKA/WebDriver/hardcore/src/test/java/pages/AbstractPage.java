package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    @FindBy(xpath = "//iframe[contains(@name,'goog_')]")
    private WebElement frame;

    @FindBy(xpath = "//iframe[@id='myFrame']")
    private WebElement myFrame;

    private final By labelAvailabilityFrame = By.xpath("//iframe[contains(@name,'goog_')]");

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void switchFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(labelAvailabilityFrame));
        driver.switchTo().frame(frame);
        driver.switchTo().frame(myFrame);
    }

    public String constructXpath(String mainXpath, String value) {
        return String.format(mainXpath, value);
    }
}