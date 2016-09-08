package gr.mod.mil.stock.dal.model.devices;

/**
 * Created by Ilias on 18/8/2016.
 */
public class Personel {

    long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    String name,surname,rank,tmhma;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTmhma() {
        return tmhma;
    }

    public void setTmhma(String tmhma) {
        this.tmhma = tmhma;
    }
}
