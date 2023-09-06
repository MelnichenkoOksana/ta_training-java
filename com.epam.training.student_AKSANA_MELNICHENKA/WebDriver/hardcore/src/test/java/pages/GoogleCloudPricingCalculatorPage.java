package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//button[@class='devsite-snackbar-action']")
    private WebElement cookieButton;

    @FindBy(xpath = "//*[@id='tab-item-1']")
    private WebElement activateSectionButton;

    @FindBy(xpath = "//md-input-container/child::input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement fieldNumberInstances;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.os']")
    WebElement fieldOperatingSystem;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement fieldVMClass;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.series']")
    private WebElement fieldSeries;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement fieldMachineType;

    @FindBy(xpath = "//md-input-container/child::md-checkbox[@ng-model='listingCtrl.computeServer.addSud']")
    private WebElement fieldAddSud;

    @FindBy(xpath = "//md-input-container/child::md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement fieldAddGPUs;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    WebElement fieldGPUType;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    WebElement fieldNumberOfGPUs;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.ssd']")
    WebElement fieldLocalSsd;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.location']")
    WebElement fieldDatacenterLocation;

    @FindBy(xpath = "//md-input-container/child::md-select[@ng-model='listingCtrl.computeServer.cud']")
    WebElement fieldCommitUsage;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    WebElement buttonAddToEstimate;

    @FindBy(xpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1'][@class='md-ink-ripple']")
    WebElement commitUsageOneYear;

    private String baseCreateXpath = "//md-option[@value='%s']";
    private String numberGPUXpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='%s']";
    private String localSSDXpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='%s']";
    private String commitUsageXpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s'][@class='md-ink-ripple']";

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage permissionUseCookie() {
        cookieButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage activateSection() {
        switchFrame();
        activateSectionButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillNumberInstancesField(String numberInstances) {
        fieldNumberInstances.click();
        fieldNumberInstances.sendKeys(numberInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillOperatingSystemField(String value) {
        fieldOperatingSystem.click();
        waitElement(driver.findElement(By.xpath(constructXpath(baseCreateXpath, value)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillVMClassField(String value) {
        fieldVMClass.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        waitElement(driver.findElement(By.xpath(constructXpath(baseCreateXpath, value)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillSeriesField(String series) {
        fieldSeries.click();
        waitElement(driver.findElement(By.xpath(constructXpath(baseCreateXpath, series)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillMachineTypeField(String machineType) {
        fieldMachineType.click();
        waitElement(driver.findElement(By.xpath(constructXpath(baseCreateXpath, machineType)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage choiceAddGPUs() {
        fieldAddSud.click();
        fieldAddGPUs.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillGPUType(String gpuType) {
        fieldGPUType.click();
        driver.findElement(By.xpath(constructXpath(baseCreateXpath, gpuType))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillNumberGPUs(String numberGPU) {
        fieldNumberOfGPUs.click();
        waitElement(driver.findElement(By.xpath(constructXpath(numberGPUXpath, numberGPU)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillLocalSSD(String localSSD) {
        fieldLocalSsd.click();
        waitElement(driver.findElement(By.xpath(constructXpath(localSSDXpath, localSSD)))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillDatacenterLocation(String datacenterLocation) {
        fieldDatacenterLocation.click();
        fieldDatacenterLocation.sendKeys(datacenterLocation);
        fieldDatacenterLocation.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillCommitUsage(String commitUsage) {
        fieldCommitUsage.click();
        waitElement(commitUsageOneYear);
        driver.findElement(By.xpath(constructXpath(commitUsageXpath, commitUsage))).click();
        return this;
    }

    public EstimatedCostPage createEstimate() {
        buttonAddToEstimate.click();
        return new EstimatedCostPage(driver);
    }
}