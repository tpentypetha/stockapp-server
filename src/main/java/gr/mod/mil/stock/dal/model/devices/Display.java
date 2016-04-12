package gr.mod.mil.stock.dal.model.devices;

import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.Entity;

@Entity
public class Display extends Device implements BarcodePrintable {

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

    public Display(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, boolean hdmi, int inches, boolean vga, boolean dvi) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.hdmi = hdmi;
        this.inches = inches;
        this.vga = vga;
        this.dvi = dvi;
    }

    public Display() {}

    @Override
    public String getBarcodeText() {
        return this.getPublicid();
    }

    @Override
    public String getPrintableText() {
        return this.getModelName();
    }
}
