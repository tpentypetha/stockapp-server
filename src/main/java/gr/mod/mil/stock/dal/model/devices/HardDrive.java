package gr.mod.mil.stock.dal.model.devices;

import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class HardDrive extends Device implements BarcodePrintable {

    @Enumerated(EnumType.STRING)
    private HardDriveTechnology technology;
    public HardDriveTechnology getTechnology() { return technology; }
    public void setTechnology(HardDriveTechnology technology) { this.technology = technology; }

    @Enumerated(EnumType.STRING)
    private HardDriveSocket socket;
    public HardDriveSocket getSocket() { return socket; }
    public void setSocket(HardDriveSocket socket) { this.socket = socket; }

    private int capacity;
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public HardDrive() {}

    public HardDrive(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, int capacity, HardDriveTechnology technology, HardDriveSocket socket) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.technology = technology;
        this.socket = socket;
        this.capacity = capacity;
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
