package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DevicePublicidGenerator;
import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Display;

public class DisplayDeviceBuilder {

    private final DevicePublicidGenerator generator = new DevicePublicidGenerator();

    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String publicid;
    private boolean hdmi;
    private int inches;
    private boolean vga;
    private boolean dvi;

    public DisplayDeviceBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public DisplayDeviceBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public DisplayDeviceBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public DisplayDeviceBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public DisplayDeviceBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public DisplayDeviceBuilder setPublicid(String publicid) {
        this.publicid = publicid;
        return this;
    }

    public DisplayDeviceBuilder setHdmi(boolean hdmi) {
        this.hdmi = hdmi;
        return this;
    }

    public DisplayDeviceBuilder setInches(int inches) {
        this.inches = inches;
        return this;
    }

    public DisplayDeviceBuilder setVga(boolean vga) {
        this.vga = vga;
        return this;
    }

    public DisplayDeviceBuilder setDvi(boolean dvi) {
        this.dvi = dvi;
        return this;
    }

    public Display createDisplay() {
        Display created = new Display(status, position, modelName, serialNum, partNum, publicid, hdmi, inches, vga, dvi);
        generator.generate(created);
        return created;
    }
}