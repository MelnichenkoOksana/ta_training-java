package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage extends AbstractPage {

    public PastebinStartPage(WebDriver driver) {
        super(driver);
    }

    public PastebinStartPage openPage(String startPageURL) {
        driver.get(startPageURL);
        return this;
    }

    public void fillingNewPasteField(String newPasteText) {
        WebElement newPasteField = driver.findElement(By.id("postform-text"));
        newPasteField.sendKeys(newPasteText);
    }

    public void fillingSyntaxHighlightingField() {
        driver.findElement(By.xpath("//*[@class='form-group field-postform-format']")).click();
        driver.findElement(By.xpath("//li[text()='Bash']")).click();
    }

    public void fillingPasteExpirationField() {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
    }

    public void fillingTitleField(String newTitleText) {
        WebElement titleField = driver.findElement(By.id("postform-name"));
        titleField.sendKeys(newTitleText);
    }

    public PastebinResultPage clickButtonCreateNewPaste() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();
        return new PastebinResultPage(driver);
    }
}
