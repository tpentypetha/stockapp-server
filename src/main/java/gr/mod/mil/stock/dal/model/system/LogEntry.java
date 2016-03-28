package gr.mod.mil.stock.dal.model.system;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class LogEntry {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    private String who;
    public String getWho() {
        return who;
    }
    public void setWho(String who) {
        this.who = who;
    }

    private String what;
    public String getWhat() {
        return what;
    }
    public void setWhat(String what) {
        this.what = what;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
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
