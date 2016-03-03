package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Loginuser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    String username;
    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    String salt;
    public String getSalt() {return salt;}
    public void setSalt(String salt) {this.salt=salt;}

}
