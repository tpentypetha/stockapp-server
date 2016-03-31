package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Switch extends Device {

    @Enumerated(EnumType.STRING)
    private SwitchPort port;
    public SwitchPort getPort() { return port; }
    public void setPort(SwitchPort port) { this.port = port; }

    private int numInterfaces;
    public int getNumInterfaces() { return numInterfaces; }
    public void setNumInterfaces(int numInterfaces) { this.numInterfaces = numInterfaces; }

    public Switch(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, SwitchPort port, int numInterfaces) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.port = port;
        this.numInterfaces = numInterfaces;
    }

    public Switch() {
    }
}
