package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DevicePublicidGenerator;
import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.dal.model.devices.PrinterTechnology;

public class PrinterDeviceBuilder {

    private final DevicePublicidGenerator generator = new DevicePublicidGenerator();

    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String publicid;
    private boolean colorPrinter;
    private boolean networkPrinter;
    private boolean multiPurposeMachine;
    private PrinterTechnology technology;

    public PrinterDeviceBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public PrinterDeviceBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public PrinterDeviceBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public PrinterDeviceBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public PrinterDeviceBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public PrinterDeviceBuilder setPublicid(String publicid) {
        this.publicid = publicid;
        return this;
    }

    public PrinterDeviceBuilder setColorPrinter(boolean colorPrinter) {
        this.colorPrinter = colorPrinter;
        return this;
    }

    public PrinterDeviceBuilder setNetworkPrinter(boolean networkPrinter) {
        this.networkPrinter = networkPrinter;
        return this;
    }

    public PrinterDeviceBuilder setMultiPurposeMachine(boolean multiPurposeMachine) {
        this.multiPurposeMachine = multiPurposeMachine;
        return this;
    }

    public PrinterDeviceBuilder setTechnology(PrinterTechnology technology) {
        this.technology = technology;
        return this;
    }

    public PrinterDevice createPrinterDevice() {
        PrinterDevice created = new PrinterDevice(status, position, modelName, serialNum, partNum, publicid, colorPrinter, networkPrinter, multiPurposeMachine, technology);
        generator.generate(created);
        return created;
    }
}