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

    private final By labelOperatingSystem = By.xpath("//md-option[@value='free']");
    private final By labelVMClassRegular = By.xpath("//md-option[@value='regular']");
    private final By labelSeriesN1 = By.xpath("//md-option[@value='n1']");
    private final By labelMachineTypeN1Standard8 = By.xpath("//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']");
    private final By labelNumberOfGPUsOne = By.xpath("//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='1']");
    private final By labelLocalSSD2x375GB = By.xpath("//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='2']");
    private final By labelCommitUsageOneYear = By.xpath("//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='1'][@class='md-ink-ripple']");

    public String baseCreateXpath = "//md-option[@value='%s']";
    public String numberGPUXpath = "//md-option[@ng-disabled='item.value != 0 && item.value < listingCtrl.minGPU' and @value='%s']";
    public String localSSDXpath = "//md-option[@ng-repeat='item in listingCtrl.dynamicSsd.computeServer' and @value='%s']";
    public String commitUsageXpath = "//div[@class='md-select-menu-container md-active md-clickable']//md-option[@value='%s'][@class='md-ink-ripple']";

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
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelOperatingSystem));

        driver.findElement(By.xpath(constructXpath(baseCreateXpath, value))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillVMClassField(String value) {
        fieldVMClass.click();
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelVMClassRegular));

        driver.findElement(By.xpath(constructXpath(baseCreateXpath, value))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillSeriesField(String series) {
        fieldSeries.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelSeriesN1));

        driver.findElement(By.xpath(constructXpath(baseCreateXpath, series))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillMachineTypeField(String machineType) {
        fieldMachineType.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelMachineTypeN1Standard8));

        driver.findElement(By.xpath(constructXpath(baseCreateXpath, machineType))).click();
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

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelNumberOfGPUsOne));

        driver.findElement(By.xpath(constructXpath(numberGPUXpath, numberGPU))).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage fillLocalSSD(String localSSD) {
        fieldLocalSsd.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(labelLocalSSD2x375GB));

        driver.findElement(By.xpath(constructXpath(localSSDXpath, localSSD))).click();
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

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.elementToBeClickable(labelCommitUsageOneYear));

        driver.findElement(By.xpath(constructXpath(commitUsageXpath, commitUsage))).click();
        return this;
    }

    public EstimatedCostPage createEstimate() {
        buttonAddToEstimate.click();
        return new EstimatedCostPage(driver);
    }
}