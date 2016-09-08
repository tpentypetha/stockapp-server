package gr.mod.mil.stock.dal.model.stock;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;
import gr.mod.mil.stock.dal.model.ordering.Orderable;
import gr.mod.mil.stock.dal.model.ordering.OrderableCategory;

import javax.persistence.*;

@Entity
public class Consumable implements Orderable, BarcodePrintable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    Long id;
    public Long getId() { return id;}
    public void setId(Long id) { this.id = id; }

    String publicid;
    public String getPublicid() { return publicid; }
    public void setPublicid(String public_id) { this.publicid = public_id; }

    String code;
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    InkColor color;
    public InkColor getColor() { return color; }
    public void setColor(InkColor color) { this.color = color;}

    boolean critical;
    public boolean getCritical() { return critical; }
    public void setCritical(boolean critical) { this.critical = critical; }

    float price;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getNumberofpages() {
        return numberofpages;
    }

    public void setNumberofpages(long numberofpages) {
        this.numberofpages = numberofpages;
    }

    long numberofpages;

    @Override
    public boolean equals(Object other) {
        return other instanceof Consumable && ((Consumable)other).getId() == this.getId();
    }

    @Override
    public String getOrderableTitle() {
        return this.getCode() + " " + this.getColor().toString();
    }

    @Override
    public OrderableCategory getCategory() {
        return OrderableCategory.CONSUMABLE;
    }

    @Override
    public String getBarcodeText() {
        return code;
    }

    @Override
    public String getPrintableText() {
        return code;
    }
}
