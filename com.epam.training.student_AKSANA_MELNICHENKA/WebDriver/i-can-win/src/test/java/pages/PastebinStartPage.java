package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PastebinStartPage {
    private static final String startPageURL = "https://pastebin.com";

    private WebDriver driver;

    public PastebinStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(startPageURL);
    }

    public void fillingNewPasteField(String newPasteText) {
        WebElement newPasteField = driver.findElement(By.id("postform-text"));
        newPasteField.sendKeys(newPasteText);
    }


    public void fillingPasteExpirationField() {
        driver.findElement(By.id("select2-postform-expiration-container")).click();
        driver.findElement(By.xpath("//li[text()='10 Minutes']")).click();
    }

    public void fillingTitleField(String newTitleText) {
        WebElement titleField = driver.findElement(By.id("postform-name"));
        titleField.sendKeys(newTitleText);
    }

    public void clickButtonCreateNewPaste() {
        driver.findElement(By.xpath("//button[text()='Create New Paste']")).click();

    }
}