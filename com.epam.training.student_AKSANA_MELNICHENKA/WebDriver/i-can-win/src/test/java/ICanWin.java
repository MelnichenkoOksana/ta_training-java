import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ICanWin {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement newPasteField = driver.findElement(By.id("postform-text"));
        newPasteField.sendKeys("Hello from WebDriver");

        WebElement expirationField = driver.findElement(By.id("select2-postform-expiration-container"));
        expirationField.click();
        WebElement tenMinutesDropdownValue = driver.findElement(By.xpath("//li[text()='10 Minutes']"));
        tenMinutesDropdownValue.click();

        WebElement titleField = driver.findElement(By.id("postform-name"));
        titleField.sendKeys("helloweb");

        WebElement button = driver.findElement(By.xpath("//button[text()='Create New Paste']"));
        button.click();

        driver.quit();

    }
}
