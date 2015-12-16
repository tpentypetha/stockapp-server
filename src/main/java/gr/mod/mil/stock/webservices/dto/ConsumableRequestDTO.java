package gr.mod.mil.stock.webservices.dto;

import gr.mod.mil.stock.dal.model.InkColor;

public class ConsumableRequestDTO {

    private String code;
    private InkColor color;
    private boolean critical;
    private int quantity;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public InkColor getColor() {
        return color;
    }

    public void setColor(InkColor color) {
        this.color = color;
    }

    public boolean getCritical() {
        return critical;
    }

    public void setCritical(boolean critical) {
        this.critical = critical;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
