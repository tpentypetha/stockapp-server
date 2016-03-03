package gr.mod.mil.stock.web.dto;

public class AddQuantityDTO {

    private String cabinetid;
    private String consumableid;
    private int quantity;


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
}
