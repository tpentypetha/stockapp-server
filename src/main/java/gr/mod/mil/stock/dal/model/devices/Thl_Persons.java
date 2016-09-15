package gr.mod.mil.stock.dal.model.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Thl_Persons {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    long id;

    long thl_tmhma_id,rank_id;
    String surname,g_name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThl_tmhma_id() {
        return thl_tmhma_id;
    }

    public void setThl_tmhma_id(long thl_tmhma_id) {
        this.thl_tmhma_id = thl_tmhma_id;
    }

    public long getRank_id() {
        return rank_id;
    }

    public void setRank_id(long rank_id) {
        this.rank_id = rank_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }
}
