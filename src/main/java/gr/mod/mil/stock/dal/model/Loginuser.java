package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Loginuser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    private String username;
    public String getUsername() { return username;}
    public void setUsername(String username) { this.username = username; }

    private String password;
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    private String salt;
    public String getSalt() {return salt;}
    public void setSalt(String salt) {this.salt=salt;}

    @Enumerated(EnumType.STRING)
    private UserType type;
    public UserType getType() { return type; }
    public void setType(UserType type) { this.type = type; }

    private boolean active;
    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

}
