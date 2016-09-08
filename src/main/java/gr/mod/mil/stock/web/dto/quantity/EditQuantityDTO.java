package gr.mod.mil.stock.web.dto.quantity;

public class EditQuantityDTO {

    private String cabinetid;
    private String quantityid;
    private int amount;
    private long deptid;

    public long getDeptid() {
        return deptid;
    }

    public void setDeptid(long deptid) {
        this.deptid = deptid;
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
