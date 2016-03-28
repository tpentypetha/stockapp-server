package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;

@Entity
public class Display extends Device {

    private int inches;
    public int getInches() { return inches; }
    public void setInches(int inches) { this.inches = inches; }

    private boolean vga;
    public boolean getVga() { return vga; }
    public void setVga(boolean vga) { this.vga = vga; }

    private boolean dvi;
    public boolean getDvi() { return dvi; }
    public void setDvi(boolean dvi) { this.dvi = dvi; }

    private boolean hdmi;
    public boolean getHdmi() { return hdmi; }
    public void setHdmi(boolean hdmi) { this.hdmi = hdmi; }

    public Display(DeviceStatus status, String position, String modelName, String serialNum, String partNum, int inches, boolean vga, boolean dvi, boolean hdmi) {
        super(status, position, modelName, serialNum, partNum);
        this.inches = inches;
        this.vga = vga;
        this.dvi = dvi;
        this.hdmi = hdmi;
    }
}
