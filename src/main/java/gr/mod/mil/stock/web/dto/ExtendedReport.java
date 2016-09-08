package gr.mod.mil.stock.web.dto;


public class ExtendedReport {

    private String depname,consumable_name;
    private long withdrawals,pages,sumpages;

    public String getDepname() {
        return depname;
    }

    public void setDepname(String depname) {
        this.depname = depname;
    }

    public String getConsumable_name() {
        return consumable_name;
    }

    public void setConsumable_name(String consumable_name) {
        this.consumable_name = consumable_name;
    }

    public long getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(long withdrawals) {
        this.withdrawals = withdrawals;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }


    public long getSumpages() {
        return sumpages;
    }

    public void setSumpages(long sumpages) {
        this.sumpages = sumpages;
    }
}
