package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class KeyboardVideoMouse extends Device {

    private int numDevicesSupported;
    public int getNumDevicesSupported() { return numDevicesSupported; }
    public void setNumDevicesSupported(int numDevicesSupported) { this.numDevicesSupported = numDevicesSupported; }

    @Enumerated(EnumType.STRING)
    private PeripheralConnectivity connectivity;
    public PeripheralConnectivity getConnectivity() { return connectivity; }
    public void setConnectivity(PeripheralConnectivity connectivity) { this.connectivity = connectivity; }

    @Enumerated(EnumType.STRING)
    private DisplayPort port;
    public DisplayPort getPort() { return port; }
    public void setPort(DisplayPort port) { this.port = port; }

    public KeyboardVideoMouse(DeviceStatus status, String position, String modelName, String serialNum, String partNum, int numDevicesSupported, PeripheralConnectivity connectivity, DisplayPort port) {
        super(status, position, modelName, serialNum, partNum);
        this.numDevicesSupported = numDevicesSupported;
        this.connectivity = connectivity;
        this.port = port;
    }

}
