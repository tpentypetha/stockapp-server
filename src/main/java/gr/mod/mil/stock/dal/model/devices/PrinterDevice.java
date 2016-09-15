package gr.mod.mil.stock.dal.model.devices;

import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class PrinterDevice extends Device implements BarcodePrintable {

    private boolean colorPrinter;
    public boolean getColorPrinter() { return colorPrinter; }
    public void setColorPrinter(boolean colorPrinter) { this.colorPrinter = colorPrinter; }

    private boolean networkPrinter;
    public boolean getNetworkPrinter() { return networkPrinter; }
    public void setNetworkPrinter(boolean networkPrinter) { this.networkPrinter = networkPrinter; }

    private boolean multiPurposeMachine;
    public boolean getMultiPurposeMachine() { return multiPurposeMachine; }
    public void setMultiPurposeMachine(boolean multiPurposeMachine) { this.multiPurposeMachine = multiPurposeMachine; }

    @Enumerated(EnumType.STRING)
    private PrinterTechnology technology;
    public PrinterTechnology getTechnology() { return technology; }
    public void setTechnology(PrinterTechnology technology) { this.technology = technology; }

    private long belongs_to;

    public long getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(long belongs_to) {
        this.belongs_to = belongs_to;
    }

    public PrinterDevice(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, boolean colorPrinter, boolean networkPrinter, boolean multiPurposeMachine, PrinterTechnology technology) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.colorPrinter = colorPrinter;
        this.networkPrinter = networkPrinter;
        this.multiPurposeMachine = multiPurposeMachine;
        this.technology = technology;
    }

    public PrinterDevice() {
    }

    @Override
    public String getBarcodeText() {
        return this.getPublicid();
    }

    @Override
    public String getPrintableText() {
        return getModelName();
    }
}
