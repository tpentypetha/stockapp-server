package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.HardDrive;
import gr.mod.mil.stock.dal.model.devices.HardDriveSocket;
import gr.mod.mil.stock.dal.model.devices.HardDriveTechnology;

public class HardDriveBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private HardDriveTechnology technology;
    private HardDriveSocket socket;
    private int capacity;

    public HardDriveBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public HardDriveBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public HardDriveBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public HardDriveBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public HardDriveBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public HardDriveBuilder setTechnology(HardDriveTechnology technology) {
        this.technology = technology;
        return this;
    }

    public HardDriveBuilder setSocket(HardDriveSocket socket) {
        this.socket = socket;
        return this;
    }

    public HardDriveBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public HardDrive createHardDrive() {
        return new HardDrive(status, position, modelName, serialNum, partNum, technology, socket, capacity);
    }
}