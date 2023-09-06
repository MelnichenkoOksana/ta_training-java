package tests;

import model.VirtualMachine;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.DropmailStartPage;
import pages.EstimatedCostPage;
import pages.GoogleCloudStartPage;
import servise.VirtualMachineCreator;
import util.TestListener;

@Listeners({TestListener.class})
public class EstimatedCostPageTest extends AbstractTest {

    public EstimatedCostPage openPage(String startPageURL) {
        VirtualMachine machine = VirtualMachineCreator.withCredentialsFromProperty();
        return new GoogleCloudStartPage(driver)
                .openPage(startPageURL)
                .pageSearch(CALCULATOR_NAME)
                .permissionUseCookie()
                .activateSection()
                .fillNumberInstancesField(machine.getNumberInstances())
                .fillOperatingSystemField(machine.getOperatingSystem())
                .fillVMClassField(machine.getMachineClass())
                .fillSeriesField(machine.getFieldSeries())
                .fillMachineTypeField(machine.getMachineType())
                .choiceAddGPUs()
                .fillGPUType(machine.getGpuType())
                .fillNumberGPUs(machine.getNumberGPU())
                .fillLocalSSD(machine.getLocalSSD())
                .fillDatacenterLocation(machine.getDatacenterLocation())
                .fillCommitUsage(machine.getCommitUsage())
                .createEstimate();
    }

    @Test
    public void chekDataTest() {
        EstimatedCostPage estimatedCostPage = openPage(GOOGLE_CLOUD_START_PAGE_URL);
        estimatedCostPage.pressEmailEstimateButton();
        createNewTab();
        switchToTab(1);
        DropmailStartPage dropmailStartPage = new DropmailStartPage(driver);
        dropmailStartPage.openPage(DROPMAIL_START_PAGE_URL);
        String emailName = dropmailStartPage.getEmailName();
        switchToTab(0);
        estimatedCostPage.switchFrame();
        estimatedCostPage.fillEmailField(emailName);
        estimatedCostPage.pressSendEmailButton();
        switchToTab(1);
        dropmailStartPage.pressHTMLButton();
        dropmailStartPage.switchFrame();

        String actualEstimatedCost = dropmailStartPage.getTotalEstimatedCost();

        assert actualEstimatedCost.contains("USD 4,024.56");
    }
}