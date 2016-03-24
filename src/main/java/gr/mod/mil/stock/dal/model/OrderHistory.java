package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class OrderHistory {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    private String publicid;
    public String getPublicid() { return publicid; }
    public void setPublicid(String publicid) { this.publicid = publicid; }

    @Temporal(TemporalType.DATE)
    private Date when;
    public Date getWhen() { return when; }
    public void setWhen(Date when) {this.when = when; }

    @OneToMany
    private List<OrderedItem> items = new ArrayList<>();
    public List<OrderedItem> getItems() { return items; }
    public void setItems(List<OrderedItem> items) { this.items = items; }

}
