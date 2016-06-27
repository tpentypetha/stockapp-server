package gr.mod.mil.stock.dal.model.stock;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contacts {

    @Id
    private String phone;

    private String name;
    private String office;
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }
}
