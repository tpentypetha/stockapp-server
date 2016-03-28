package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Telephone;

public class TelephoneBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private boolean digital;
    private boolean fax;

    public TelephoneBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public TelephoneBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public TelephoneBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public TelephoneBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public TelephoneBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public TelephoneBuilder setDigital(boolean digital) {
        this.digital = digital;
        return this;
    }

    public TelephoneBuilder setFax(boolean fax) {
        this.fax = fax;
        return this;
    }

    public Telephone createTelephone() {
        return new Telephone(status, position, modelName, serialNum, partNum, digital, fax);
    }
}