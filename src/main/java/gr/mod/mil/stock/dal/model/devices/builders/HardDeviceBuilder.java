package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.*;

public class HardDeviceBuilder {

    private final DevicePublicidGenerator generator = new DevicePublicidGenerator();

    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String publicid;
    private int capacity;
    private HardDriveTechnology technology;
    private HardDriveSocket socket;

    public HardDeviceBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public HardDeviceBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public HardDeviceBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public HardDeviceBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public HardDeviceBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public HardDeviceBuilder setPublicid(String publicid) {
        this.publicid = publicid;
        return this;
    }

    public HardDeviceBuilder setCapacity(int capacity){
        this.capacity = capacity;
        return this;
    }

    public HardDeviceBuilder setTechnology(HardDriveTechnology technology) {
        this.technology = technology;
        return this;
    }

    public HardDeviceBuilder setSocket(HardDriveSocket socket) {
        this.socket = socket;
        return this;
    }

    public HardDrive createHardDrive() {
        HardDrive created = new HardDrive(status, position, modelName, serialNum, partNum, publicid, capacity, technology, socket);
        generator.generate(created);
        return created;
    }
}
