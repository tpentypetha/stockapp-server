package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Switch;
import gr.mod.mil.stock.dal.model.devices.SwitchPort;

public class SwitchBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private SwitchPort port;
    private int numInterfaces;

    public SwitchBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public SwitchBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public SwitchBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public SwitchBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public SwitchBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public SwitchBuilder setPort(SwitchPort port) {
        this.port = port;
        return this;
    }

    public SwitchBuilder setNumInterfaces(int numInterfaces) {
        this.numInterfaces = numInterfaces;
        return this;
    }

    public Switch createSwitch() {
        return new Switch(status, position, modelName, serialNum, partNum, port, numInterfaces);
    }
}