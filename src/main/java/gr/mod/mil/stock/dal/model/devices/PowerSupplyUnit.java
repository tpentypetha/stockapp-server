package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;

@Entity
public class PowerSupplyUnit extends Device {

    private int watt;
    public int getWatt() { return watt; }
    public void setWatt(int watt) { this.watt = watt; }

    private  int sataSockets;
    public int getSataSockets() { return sataSockets; }
    public void setSataSockets(int sataSockets) { this.sataSockets = sataSockets; }

    private int ideSockets;
    public int getIdeSockets() { return ideSockets; }
    public void setIdeSockets(int ideSockets) { this.ideSockets = ideSockets; }

    public PowerSupplyUnit(DeviceStatus status, String position, String modelName, String serialNum, String partNum, int watt, int sataSockets, int ideSockets) {
        super(status, position, modelName, serialNum, partNum);
        this.watt = watt;
        this.sataSockets = sataSockets;
        this.ideSockets = ideSockets;
    }

}
