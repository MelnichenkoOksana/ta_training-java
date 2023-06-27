package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EstimatedCostPage {
    public WebDriver driver;
    public String startPageURL = "https://dropmail.me/ru/";

    public EstimatedCostPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressButtonEmailEstimate() {
        driver.findElement(By.xpath("//button[@title='Email Estimate']/span")).click();
    }

//    public void switchFrame(){
////        new WebDriverWait(driver, Duration.ofSeconds(10))
////                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//iframe[@name='apiproxybd15cc554eb92f15dfb37a578573c09005d7c73a0.4237267569']")));
////        WebElement frame = driver.findElement(By.xpath("//iframe[@name='apiproxybd15cc554eb92f15dfb37a578573c09005d7c73a0.4237267569']"));
//        WebElement frame = driver.findElement(By.xpath("//*[@id='apiproxybd15cc554eb92f15dfb37a578573c09005d7c73a0.4237267569']"));
//        driver.switchTo().frame(frame);
//        driver.switchTo().frame("myFrame");
//    }

    public void switchToFrame() {
        WebElement iFrame = driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe"));
        driver.switchTo().frame(iFrame);
        WebElement myFrame = driver.findElement(By.xpath("//*[@id='myFrame']"));
        driver.switchTo().frame(myFrame);
    }

    public String getEmailName(){
        DropmailStartPage yopmailStartPage = new DropmailStartPage(driver);
        yopmailStartPage.openPage(startPageURL);
        return yopmailStartPage.getEmailName();
    }

    public void fillEmail (){

        WebElement fieldEmail = driver.findElement(By.xpath("//*[@id='input_565']"));
        fieldEmail.click();
        fieldEmail.sendKeys(getEmailName());
    }
}
