package gr.mod.mil.stock.web.dto;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.HardDriveSocket;
import gr.mod.mil.stock.dal.model.devices.HardDriveTechnology;

public class HardDeviceDTO {

    private String publicid;
    private DeviceStatus status;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String position;
    private int capacity;
    private HardDriveTechnology technology;
    private HardDriveSocket socket;

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

    public int getCapacity() { return capacity; }

    public void setCapacity (int capacity) { this.capacity = capacity;}

    public HardDriveTechnology getTechnology() {return technology;}

    public void setTechnology(HardDriveTechnology technology) {this.technology = technology;}

    public HardDriveSocket getSocket() {return socket;}

    public void setSocket(HardDriveSocket socket) {this.socket = socket;}

    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }

}
