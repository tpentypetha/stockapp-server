package gr.mod.mil.stock.web.dto;

/**
 * Created by Ilias on 14/7/2016.
 */
public class BriefReport {

    private String name;
    private float price;
    private long withdrawals,pages;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
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
}
