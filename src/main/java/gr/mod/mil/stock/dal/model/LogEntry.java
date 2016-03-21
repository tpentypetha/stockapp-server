package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogEntry {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;

    private String who;

    private String what;

    @Temporal(TemporalType.TIMESTAMP)
    private Date when;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public Date getWhen() {
        return when;
    }

    public void setWhen(Date when) {
        this.when = when;
    }

    public String toString() {
        return "[LOG] " + when.toString() + " " + who + " " + what;
    }
}
