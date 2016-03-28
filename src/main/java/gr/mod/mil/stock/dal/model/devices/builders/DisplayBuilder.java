package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Display;

public class DisplayBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private int inches;
    private boolean vga;
    private boolean dvi;
    private boolean hdmi;

    public DisplayBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public DisplayBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public DisplayBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public DisplayBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public DisplayBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public DisplayBuilder setInches(int inches) {
        this.inches = inches;
        return this;
    }

    public DisplayBuilder setVga(boolean vga) {
        this.vga = vga;
        return this;
    }

    public DisplayBuilder setDvi(boolean dvi) {
        this.dvi = dvi;
        return this;
    }

    public DisplayBuilder setHdmi(boolean hdmi) {
        this.hdmi = hdmi;
        return this;
    }

    public Display createDisplay() {
        return new Display(status, position, modelName, serialNum, partNum, inches, vga, dvi, hdmi);
    }
}