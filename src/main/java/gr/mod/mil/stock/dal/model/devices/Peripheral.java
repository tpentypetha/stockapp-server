package gr.mod.mil.stock.dal.model.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.*;

@Entity
public class Peripheral implements BarcodePrintable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    long id;

    String type;

    String publicid;

    private long belongs_to;

    public long getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(long belongs_to) {
        this.belongs_to = belongs_to;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }

    @Override
    public String getBarcodeText(){ return publicid.replace('-',' ').trim().substring(0,9);}

    @Override
    public String getPrintableText(){ return type.replaceAll("\\s","").substring(0,5); }

}
