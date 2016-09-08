package gr.mod.mil.stock.dal.model.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class KeyboardVideoMouse implements BarcodePrintable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    long id;

    String status,model_name,PUBLICID;
    int NUM_DEVICES_SUPPORTED;
    private long belongs_to;

    public long getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(long belongs_to) {
        this.belongs_to = belongs_to;
    }

    public int getNUM_DEVICES_SUPPORTED() {
        return NUM_DEVICES_SUPPORTED;
    }

    public void setNUM_DEVICES_SUPPORTED(int NUM_DEVICES_SUPPORTED) {
        this.NUM_DEVICES_SUPPORTED = NUM_DEVICES_SUPPORTED;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }





    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }



    public String getPUBLICID() {
        return PUBLICID;
    }

    public void setPUBLICID(String PUBLICID) {
        this.PUBLICID = PUBLICID;
    }

    @Override
    public String getBarcodeText() {
        return this.getPUBLICID().replace('-',' ').trim().substring(0,9);
    }

    @Override
    public String getPrintableText() {
        return getModel_name().replaceAll("\\s","").substring(0,5);
    }




}
