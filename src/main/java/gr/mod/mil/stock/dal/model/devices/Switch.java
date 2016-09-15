package gr.mod.mil.stock.dal.model.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.*;

@Entity
public class Switch implements BarcodePrintable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    long id;

    String publicid, model_name, usb_lan;
    long belongs_to, num_interfaces;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }

    public String getUsb_lan() {
        return usb_lan;
    }

    public void setUsb_lan(String usb_lan) {
        this.usb_lan = usb_lan;
    }

    public long getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(long belongs_to) {
        this.belongs_to = belongs_to;
    }

    public long getNum_interfaces() {
        return num_interfaces;
    }

    public void setNum_interfaces(long num_interfaces) {
        this.num_interfaces = num_interfaces;
    }

    @Override
    public String getBarcodeText(){ return publicid.replace('-',' ').trim().substring(0,9);}

    @Override
    public String getPrintableText(){ return model_name.replaceAll("\\s","").substring(0,5); }

}
