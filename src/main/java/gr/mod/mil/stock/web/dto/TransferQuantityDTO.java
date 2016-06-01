package gr.mod.mil.stock.web.dto;

public class TransferQuantityDTO {


    private String cabinetid;
    private String consumableid;
    private int quantity;
    private String ToCabinetid;

    public String getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(String cabinetid) {
        this.cabinetid = cabinetid;
    }

    public String getConsumableid() {
        return consumableid;
    }

    public void setConsumableid(String consumableid) {
        this.consumableid = consumableid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getToCabinetid() {
        return ToCabinetid;
    }

    public void setToCabinetid(String toCabinetid) {
        ToCabinetid = toCabinetid;
    }
}
