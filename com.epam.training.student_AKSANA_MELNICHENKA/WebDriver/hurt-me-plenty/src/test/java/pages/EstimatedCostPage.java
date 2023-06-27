package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EstimatedCostPage extends AbstractPage {

    public EstimatedCostPage(WebDriver driver) {
        super(driver);
    }

    public String getVMClass() {
        return driver.findElement(By.xpath("//div[contains (text(),'Provisioning model:')]")).getText();
    }

    public boolean checkInstanceType(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Instance type:')]")).getText();
        return actualValue.contains(expectedValue);
    }

    public boolean checkRegion(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Region:')]")).getText();
        return actualValue.contains(expectedValue);
    }

    public boolean checkLocalSSD(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Local SSD:')]")).getText();
        return actualValue.contains(expectedValue);
    }

    public boolean checkCommitmentTerm(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//div[contains (text(),'Commitment term:')]")).getText();
        return actualValue.contains(expectedValue);
    }

    public boolean checkTotalEstimatedCost(String expectedValue) {
        String actualValue = driver.findElement(By.xpath("//*[contains (text(),'Estimated Component Cost:')]")).getText();
        return actualValue.contains(expectedValue);
    }


}
