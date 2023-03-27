package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PastebinResultPage {

    private WebDriver driver;

    public PastebinResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTittle(){
        return driver.findElement(By.xpath("//div[@class='info-top']")).getText();
    }

    public String getSyntaxHighlighting(){
        return driver.findElement(By.xpath("//div[@class='left']//a[@class='btn -small h_800']")).getText();
    }

    public String getCodeMatches(){
        return driver.findElement(By.xpath("//div[@class='source bash']")).getText();
    }

}
