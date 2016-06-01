package gr.mod.mil.stock.web.dto;

import gr.mod.mil.stock.dal.model.stock.Consumable;

public class GenericConsumableReportRow {

    private Consumable consumable;
    private String deposits;
    private String withdrawals;
    private String currentSupply;

    public Consumable getConsumable() {
        return consumable;
    }

    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }

    public String getDeposits() {
        return deposits;
    }

    public void setDeposits(String deposits) {
        this.deposits = deposits;
    }

    public String getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(String withdrawals) {
        this.withdrawals = withdrawals;
    }

    public String getCurrentSupply() {
        return currentSupply;
    }

    public void setCurrentSupply(String currentSupply) {
        this.currentSupply = currentSupply;
    }

    public boolean isLow() {
        try {
            return Integer.parseInt(this.currentSupply) < 3;
        } catch(Exception e){return false; }
    }
}
