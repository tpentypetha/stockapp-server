package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Peripheral extends Device {

    @Enumerated(EnumType.STRING)
    private PeripheralConnectivity connectivity;
    public PeripheralConnectivity getConnectivity() { return connectivity; }
    public void setConnectivity(PeripheralConnectivity connectivity) {
        this.connectivity = connectivity;
    }

    private boolean mouse;
    public boolean isMouse() {
        return mouse;
    }
    public void setMouse(boolean mouse) {
        this.mouse = mouse;
    }

    private boolean keyboard;
    public boolean isKeyboard() {
        return keyboard;
    }
    public void setKeyboard(boolean keyboard) {
        this.keyboard = keyboard;
    }

    public Peripheral(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, PeripheralConnectivity connectivity, boolean mouse, boolean keyboard) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.connectivity = connectivity;
        this.mouse = mouse;
        this.keyboard = keyboard;
    }

    public Peripheral() {
    }
}
