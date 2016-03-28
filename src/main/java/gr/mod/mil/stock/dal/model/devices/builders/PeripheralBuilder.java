package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Peripheral;
import gr.mod.mil.stock.dal.model.devices.PeripheralConnectivity;

public class PeripheralBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private PeripheralConnectivity connectivity;
    private boolean mouse;
    private boolean keyboard;

    public PeripheralBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public PeripheralBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public PeripheralBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public PeripheralBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public PeripheralBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public PeripheralBuilder setConnectivity(PeripheralConnectivity connectivity) {
        this.connectivity = connectivity;
        return this;
    }

    public PeripheralBuilder setMouse(boolean mouse) {
        this.mouse = mouse;
        return this;
    }

    public PeripheralBuilder setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
        return this;
    }

    public Peripheral createPeripheral() {
        return new Peripheral(status, position, modelName, serialNum, partNum, connectivity, mouse, keyboard);
    }
}