package gr.mod.mil.stock.dal.model.stock;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

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


    @Override
    public boolean equals(Object o){
        if( !(o instanceof Cabinet))
            return false;

        Cabinet another = (Cabinet) o;
        return this.getId() == another.getId();
    }

    @Override
    public int hashCode(){
        return 0;
    }
}
