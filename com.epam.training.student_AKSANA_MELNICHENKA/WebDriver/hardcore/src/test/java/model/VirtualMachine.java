package model;

import java.util.Objects;

public class VirtualMachine {
    private String numberInstances;
    private String operatingSystem;
    private String machineClass;
    private String machineSeries;
    private String machineType;
    private String addGPUs;
    private String gpuType;
    private String numberGPU;
    private String LocalSSD;
    private String datacenterLocation;
    private String commitUsage;

    public VirtualMachine(String numberInstances, String operatingSystem, String machineClass,
                          String fieldSeries, String fieldMachineType, String addGPUs, String gpuType,
                          String numberOfGPUs, String localSSD, String datacenterLocation, String commitUsage) {
        this.numberInstances = numberInstances;
        this.operatingSystem = operatingSystem;
        this.machineClass = machineClass;
        this.machineSeries = fieldSeries;
        this.machineType = fieldMachineType;
        this.addGPUs = addGPUs;
        this.gpuType = gpuType;
        this.numberGPU = numberOfGPUs;
        this.LocalSSD = localSSD;
        this.datacenterLocation = datacenterLocation;
        this.commitUsage = commitUsage;
    }

    public String getNumberInstances() {
        return numberInstances;
    }

    public void setNumberInstances(String numberInstances) {
        this.numberInstances = numberInstances;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getMachineClass() {
        return machineClass;
    }

    public void setMachineClass(String machineClass) {
        this.machineClass = machineClass;
    }

    public String getFieldSeries() {
        return machineSeries;
    }

    public void setFieldSeries(String fieldSeries) {
        this.machineSeries = fieldSeries;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getAddGPUs() {
        return addGPUs;
    }

    public void setAddGPUs(String addGPUs) {
        this.addGPUs = addGPUs;
    }

    public String getGpuType() {
        return gpuType;
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public String getNumberGPU() {
        return numberGPU;
    }

    public void setNumberGPU(String numberGPU) {
        this.numberGPU = numberGPU;
    }

    public String getLocalSSD() {
        return LocalSSD;
    }

    public void setLocalSSD(String localSSD) {
        LocalSSD = localSSD;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public String getCommitUsage() {
        return commitUsage;
    }

    public void setCommitUsage(String commitUsage) {
        this.commitUsage = commitUsage;
    }

    @Override
    public String toString() {
        return "VirtualMachine{" +
                "numberInstances='" + numberInstances + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ", machineClass='" + machineClass + '\'' +
                ", fieldSeries='" + machineSeries + '\'' +
                ", fieldMachineType='" + machineType + '\'' +
                ", addGPUs='" + addGPUs + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", numberOfGPUs='" + numberGPU + '\'' +
                ", LocalSSD='" + LocalSSD + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", commitUsage='" + commitUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VirtualMachine that = (VirtualMachine) o;
        return Objects.equals(numberInstances, that.numberInstances) &&
                Objects.equals(operatingSystem, that.operatingSystem) &&
                Objects.equals(machineClass, that.machineClass) &&
                Objects.equals(machineSeries, that.machineSeries) &&
                Objects.equals(machineType, that.machineType) &&
                Objects.equals(addGPUs, that.addGPUs) &&
                Objects.equals(gpuType, that.gpuType) &&
                Objects.equals(numberGPU, that.numberGPU) &&
                Objects.equals(LocalSSD, that.LocalSSD) &&
                Objects.equals(datacenterLocation, that.datacenterLocation) &&
                Objects.equals(commitUsage, that.commitUsage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberInstances, operatingSystem, machineClass, machineSeries, machineType, addGPUs,
                gpuType, numberGPU, LocalSSD, datacenterLocation, commitUsage);
    }
}
