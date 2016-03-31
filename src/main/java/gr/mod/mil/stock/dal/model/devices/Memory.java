package gr.mod.mil.stock.dal.model.devices;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Memory extends Device {

    @Enumerated(EnumType.STRING)
    private MemorySocket socket;
    public MemorySocket getSocket() { return socket; }
    public void setSocket(MemorySocket socket) { this.socket = socket; }

    private int capacity;
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public Memory(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, MemorySocket socket, int capacity) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.socket = socket;
        this.capacity = capacity;
    }

    public Memory() {
    }
}
