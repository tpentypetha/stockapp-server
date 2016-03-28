package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.DisplayPort;
import gr.mod.mil.stock.dal.model.devices.KeyboardVideoMouse;
import gr.mod.mil.stock.dal.model.devices.PeripheralConnectivity;

public class KeyboardVideoMouseBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private int numDevicesSupported;
    private PeripheralConnectivity connectivity;
    private DisplayPort port;

    public KeyboardVideoMouseBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public KeyboardVideoMouseBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public KeyboardVideoMouseBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public KeyboardVideoMouseBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public KeyboardVideoMouseBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public KeyboardVideoMouseBuilder setNumDevicesSupported(int numDevicesSupported) {
        this.numDevicesSupported = numDevicesSupported;
        return this;
    }

    public KeyboardVideoMouseBuilder setConnectivity(PeripheralConnectivity connectivity) {
        this.connectivity = connectivity;
        return this;
    }

    public KeyboardVideoMouseBuilder setPort(DisplayPort port) {
        this.port = port;
        return this;
    }

    public KeyboardVideoMouse createKeyboardVideoMouse() {
        return new KeyboardVideoMouse(status, position, modelName, serialNum, partNum, numDevicesSupported, connectivity, port);
    }
}