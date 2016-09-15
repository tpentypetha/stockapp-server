package gr.mod.mil.stock.web.dto.quantity;

public class EditQuantityDTO {

    private String cabinetid;
    private String quantityid;
    private int amount;
    private String dept_desc;

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }

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
