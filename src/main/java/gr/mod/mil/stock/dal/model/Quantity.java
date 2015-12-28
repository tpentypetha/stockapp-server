package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Quantity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;
    public long getId() { return id; }
    public void setId(long id) {this.id = id;}

    private String publicid;
    public String getPublicid() {return publicid;}
    public void setPublicid(String publicid) {this.publicid = publicid;}

    @OneToOne
    private Consumable consumable;
    public Consumable getConsumable() {return consumable;}
    public void setConsumable(Consumable consumable) {this.consumable = consumable;}

    private int amount;
    public int getAmount() {return amount;}
    public void setAmount(int amount) {this.amount = amount;}

    public void setEmpty(){
        this.amount = 0;
    }

}
