package servise;

import model.VirtualMachine;

public class VirtualMachineCreator {
    public static final String TESTDATA_NUMBER_INSTANCE = "testdata.number.instances";
    public static final String TESTDATA_OPERATING_SYSTEM = "testdata.operating.system";
    public static final String TESTDATA_MACHINE_CLASS = "testdata.machine.class";
    public static final String TESTDATA_MACHINE_SERIES = "testdata.machine.series";
    public static final String TESTDATA_MACHINE_TYPE = "testdata.machine.type";
    public static final String TESTDATA_ADD_GPU = "testdata.add.gpu";
    public static final String TESTDATA_GPU_TYPE = "testdata.gpu.type";
    public static final String TESTDATA_NUMBER_GPU = "testdata.number.gpu";
    public static final String TESTDATA_LOCAL_SSD = "testdata.local.ssd";
    public static final String TESTDATA_DATACENTER_LOCATION = "testdata.datacenter.location";
    public static final String TESTDATA_COMMIT_USAGE = "testdata.commit.usage";


    public static VirtualMachine withCredentialsFromProperty() {
        return new VirtualMachine(TestDataReader.getData(TESTDATA_NUMBER_INSTANCE),
                TestDataReader.getData(TESTDATA_OPERATING_SYSTEM),
                TestDataReader.getData(TESTDATA_MACHINE_CLASS),
                TestDataReader.getData(TESTDATA_MACHINE_SERIES),
                TestDataReader.getData(TESTDATA_MACHINE_TYPE),
                TestDataReader.getData(TESTDATA_ADD_GPU),
                TestDataReader.getData(TESTDATA_GPU_TYPE),
                TestDataReader.getData(TESTDATA_NUMBER_GPU),
                TestDataReader.getData(TESTDATA_LOCAL_SSD),
                TestDataReader.getData(TESTDATA_DATACENTER_LOCATION),
                TestDataReader.getData(TESTDATA_COMMIT_USAGE));
    }
}
