package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Consumable {

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

    @Override
    public boolean equals(Object other) {
        return other instanceof Consumable && ((Consumable)other).getId() == this.getId();
    }


}
