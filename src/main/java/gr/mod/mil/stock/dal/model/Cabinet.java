package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    String name;
    public String getName() { return name;}
    public void setName(String name) { this.name = name; }

    String publicid;
    public String getPublicid() { return publicid; }
    public void setPublicid(String publicid) { this.publicid = publicid; }

    @OneToMany(fetch = FetchType.EAGER)
    List<Quantity> quantities;
    public List<Quantity> getQuantities() {return quantities;}
    public void setQuantities(List<Quantity> quantities) {this.quantities = quantities;}

}
