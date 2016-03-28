package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PowerSupplyUnit;

public class PowerSupplyUnitBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private int watt;
    private int sataSockets;
    private int ideSockets;

    public PowerSupplyUnitBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public PowerSupplyUnitBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public PowerSupplyUnitBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public PowerSupplyUnitBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public PowerSupplyUnitBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public PowerSupplyUnitBuilder setWatt(int watt) {
        this.watt = watt;
        return this;
    }

    public PowerSupplyUnitBuilder setSataSockets(int sataSockets) {
        this.sataSockets = sataSockets;
        return this;
    }

    public PowerSupplyUnitBuilder setIdeSockets(int ideSockets) {
        this.ideSockets = ideSockets;
        return this;
    }

    public PowerSupplyUnit createPowerSupplyUnit() {
        return new PowerSupplyUnit(status, position, modelName, serialNum, partNum, watt, sataSockets, ideSockets);
    }
}