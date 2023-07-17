package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudStartPage extends AbstractPage {


    public GoogleCloudStartPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("devsite-search-form")));
        return this;
    }

    public void pageSearch(String requestText) {
        WebElement searchElement = driver.findElement(By.className("devsite-search-form"));
        searchElement.click();
        WebElement entryField = driver.findElement(By.xpath("//input[@class='devsite-search-field devsite-search-query']"));
        entryField.sendKeys(requestText);
        entryField.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("gs-title")));
        WebElement linkCalculator = driver.findElement(By.xpath("//b[text() = 'Google Cloud Pricing Calculator']"));
        linkCalculator.click();
    }

}