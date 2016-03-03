package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    String name;
    public String getName() { return name;}
    public void setName(String name) { this.name = name; }
}
