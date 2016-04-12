package gr.mod.mil.stock.web.dto;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PrinterTechnology;


public class PrinterDeviceDTO {

    private String publicid;
    private DeviceStatus status;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String position;
    private PrinterTechnology technology;
    private boolean colorPrinter;
    private boolean networkPrinter;
    private boolean multiPurposeMachine;

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position ;
    }

    public PrinterTechnology getTechnology() {return technology;}

    public void setTechnology(PrinterTechnology technology) {this.technology = technology;}

    public boolean getColorPrinter() {
        return colorPrinter;
    }

    public void setColorPrinter(boolean colorPrinter) {
        this.colorPrinter = colorPrinter;
    }

    public boolean getNetworkPrinter() {
        return networkPrinter;
    }

    public void setNetworkPrinter(boolean networkPrinter) {
        this.networkPrinter = networkPrinter;
    }

    public boolean getMultiPurposeMachine() {
        return multiPurposeMachine;
    }

    public void setMultiPurposeMachine(boolean multiPurposeMachine) {
        this.multiPurposeMachine = multiPurposeMachine;
    }


    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }
}
