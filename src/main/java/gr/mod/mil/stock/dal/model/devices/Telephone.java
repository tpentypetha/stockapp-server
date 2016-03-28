package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;

@Entity
public class Telephone extends Device {

    private boolean digital;
    public boolean getDigital() { return digital; }
    public void setDigital(boolean digital) { this.digital = digital; }

    private boolean fax;
    public boolean getFax() { return  fax; }
    public void setFax(boolean fax) { this.fax = fax; }

    public Telephone(DeviceStatus status, String position, String modelName, String serialNum, String partNum, boolean digital, boolean fax) {
        super(status, position, modelName, serialNum, partNum);
        this.digital = digital;
        this.fax = fax;
    }
}
