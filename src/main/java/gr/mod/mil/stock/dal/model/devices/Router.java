package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;

@Entity
public class Router extends Device {

    private boolean supportsVdsl;
    public boolean getSupportsVdsl() { return supportsVdsl; }
    public void setSupportsVdsl(boolean supportsVdsl) { this.supportsVdsl = supportsVdsl; }

    private boolean wireless;
    public boolean getWireless() { return wireless; }
    public void setWireless(boolean wireless) { this.wireless = wireless; }

    private int numLans;
    public int getNumLans() { return numLans; }
    public void setNumLans(int numLans) { this.numLans = numLans; }

    public Router(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, boolean supportsVdsl, boolean wireless, int numLans) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.supportsVdsl = supportsVdsl;
        this.wireless = wireless;
        this.numLans = numLans;
    }

    public Router() {
    }
}
