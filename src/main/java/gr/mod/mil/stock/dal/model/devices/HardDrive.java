package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class HardDrive extends Device {

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

    public HardDrive(DeviceStatus status, String position, String modelName, String serialNum, String partNum, HardDriveTechnology technology, HardDriveSocket socket, int capacity) {
        super(status, position, modelName, serialNum, partNum);
        this.technology = technology;
        this.socket = socket;
        this.capacity = capacity;
    }

}
