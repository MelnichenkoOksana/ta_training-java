package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public void activateSection() {
        driver.findElement(By.xpath("//*[@id='tab-item-1']")).click();
    }

    public void fillFieldNumberInstances() {
        WebElement fieldNumberInstances = driver.findElement(By.xpath("//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']"));
        fieldNumberInstances.click();
        fieldNumberInstances.sendKeys("4");
    }

    public void fillFieldOperatingSystem() {
        WebElement fieldOperatingSystem = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.os']"));
        fieldOperatingSystem.click();
        driver.findElement(By.xpath("//md-option[@value='free']")).click();
    }

    public void fillFieldVMClass() {
        driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.class']")).click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='regular']")));

        WebElement fieldVMClass = driver.findElement(By.xpath("//md-option[@value='regular']"));
        fieldVMClass.click();
    }

    public void fillFieldSeries() {
        WebElement fieldSeries = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.series']"));
        fieldSeries.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='n1']")));

        driver.findElement(By.xpath("//md-option[@value='n1']")).click();
    }

    public void fillFieldMachineType() {
        WebElement fieldMachineType = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.instance']"));
        fieldMachineType.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")));

        driver.findElement(By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")).click(); //выбирает не ту строку
    }

    public void choiceAddGPUs() {
        driver.findElement(By.xpath("//md-input-container/child::md-checkbox[@ng-model='listingCtrl.computeServer.addSud']")).click();
        driver.findElement(By.xpath("//md-input-container/child::md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")).click();
    }

    public void fillGPUType() {
        WebElement fieldGPUType = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.gpuType']"));
        fieldGPUType.click();
        driver.findElement(By.xpath("//md-option[@value='NVIDIA_TESLA_P100']")).click();
    }

    public void fillNumberOfGPUs() {
        WebElement fieldGPUType = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.gpuCount']"));
        fieldGPUType.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")));

        driver.findElement(By.xpath("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']")).click();
    }

    public void fillLocalSSD() {
        WebElement fieldLocalSSD = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.ssd']"));
        fieldLocalSSD.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']")));

        driver.findElement(By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']")).click();
    }

    public void fillDatacenterLocation() {
        WebElement fieldDatacenterLocation = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.location']"));
        fieldDatacenterLocation.click();

        fieldDatacenterLocation.sendKeys("Frankfurt (europe-west3)");
        fieldDatacenterLocation.click();
    }

    public void fillCommitUsage() {
        WebElement fieldCommitUsage = driver.findElement(By.xpath("//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.cud']"));
        fieldCommitUsage.click();


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" +
                " md-option[value='1'][class='md-ink-ripple']")));


        driver.findElement(By.cssSelector("div[class='md-select-menu-container md-active md-clickable']" +
                " md-option[value='1'][class='md-ink-ripple']")).click();
    }

    public void createEstimate() {
        driver.findElement(By.xpath("//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")).click();
    }

}