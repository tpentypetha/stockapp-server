package gr.mod.mil.stock.web.dto;

public class EditQuantityDTO {

    private String cabinetid;
    private String quantityid;
    private int amount;


    public String getQuantityid() {
        return quantityid;
    }

    public void setQuantityid(String quantityid) {
        this.quantityid = quantityid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCabinetid() {
        return cabinetid;
    }

    public void setCabinetid(String cabinetid) {
        this.cabinetid = cabinetid;
    }
}
