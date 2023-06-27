package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropmailStartPage {

    public WebDriver driver;

    public DropmailStartPage(WebDriver driver) {
        this.driver = driver;
    }

    public DropmailStartPage openPage(String startPageURL){

        String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText(startPageURL)).sendKeys(selectLinkOpeninNewTab);
//        driver.get(startPageURL);
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("container")));
        return this;
    }

    public String getEmailName() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[2]/div[4]/div/div/div/span[1]")));
        return driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/span[1]")).getText();
    }


}
