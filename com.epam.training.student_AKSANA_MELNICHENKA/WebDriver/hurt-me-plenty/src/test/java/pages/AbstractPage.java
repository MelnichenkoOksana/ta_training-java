package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchFrame() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//iframe[contains(@name,'goog_')]")));
        WebElement frame = driver.findElement(By.xpath("//iframe[contains(@name,'goog_')]"));
        driver.switchTo().frame(frame);
        driver.switchTo().frame("myFrame");
    }
}
