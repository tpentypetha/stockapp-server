package gr.mod.mil.stock.web.dto.printer;

public class RemovePrinterConsumableDTO {

    private String printerid;
    private String consumableid;

    public String getPrinterid() {
        return printerid;
    }

    public void setPrinterid(String printerid) {
        this.printerid = printerid;
    }

    public String getConsumableid() {
        return consumableid;
    }

    public void setConsumableid(String consumableid) {
        this.consumableid = consumableid;
    }
}
