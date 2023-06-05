package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatedCostPage {
    public WebDriver driver;

    public EstimatedCostPage(WebDriver driver) {
        this.driver = driver;
    }

//    Проверить соответствие данных следующих полей: VM Class, Instance type, Region, local SSD, commitment term

    public void checkVMClass (String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Provisioning model:')]")).getText();
        actualValue.contains(expectedValue);
    }

    public void checkInstanceType(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Instance type:')]")).getText();
        actualValue.contains(expectedValue);
    }

    public void checkRegion(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Region:')]")).getText();
        actualValue.contains(expectedValue);
    }

    public  void checkLocalSSD(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Local SSD:')]")).getText();
        actualValue.contains(expectedValue);
    }

    public void checkCommitmentTerm(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Commitment term:')]")).getText();
        actualValue.contains(expectedValue);
    }

    public void checkTotalEstimatedCost(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//*[contains (text(),'Estimated Component Cost:')]")).getText();
        actualValue.contains(expectedValue);
    }


}
