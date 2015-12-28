package gr.mod.mil.stock.webservices.dto;


public class AddQuantityRequestDTO {

    private String cabinetid;
    private String consumableid;
    private int amount;


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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
