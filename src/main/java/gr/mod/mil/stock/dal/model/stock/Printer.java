package gr.mod.mil.stock.dal.model.stock;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Printer {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    Long id;
    public Long getId() {return id;}
    public void setId(Long id) { this.id = id;}

    String publicid;
    public String getPublicid() { return publicid;}
    public void setPublicid(String public_id) { this.publicid = public_id; }

    String name;
    public String getName() { return name;}
    public void setName(String name) {this.name = name;}

    @OneToMany(fetch = FetchType.EAGER)
    List<Consumable> uses = new ArrayList<>();
    public List<Consumable> getUses() { return uses; }
    public void setUses(List<Consumable> uses) { this.uses = uses; }

}
