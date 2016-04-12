package gr.mod.mil.stock.web.dto;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;

public class DisplayDeviceDTO {

    private String publicid;
    private DeviceStatus status;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String position;
    private int inches;
    private boolean vga;
    private boolean dvi;
    private boolean hdmi;

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

    public int getInches() { return inches; }

    public void setInches (int inches) { this.inches = inches; }

    public boolean getVga() { return vga; }

    public void setVga(boolean vga) { this.vga = vga; }

    public boolean getDvi() { return dvi; }

    public void setDvi(boolean dvi) { this.dvi = dvi; }

    public boolean getHdmi() { return hdmi; }

    public void setHdmi (boolean hdmi) { this.hdmi = hdmi; }



    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }

}
