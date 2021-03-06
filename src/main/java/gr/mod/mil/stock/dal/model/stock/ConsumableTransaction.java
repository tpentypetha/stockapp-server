package gr.mod.mil.stock.dal.model.stock;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
public class ConsumableTransaction {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id;}

    @OneToOne
    private Consumable consumable;
    public Consumable getConsumable() { return consumable; }
    public void setConsumable(Consumable consumable) { this.consumable = consumable; }

    private int withdrawamount;
    public int getWithdrawamount() { return withdrawamount; }
    public void setWithdrawamount(int withdrawamount) { this.withdrawamount = withdrawamount; }

    private int depositamount;
    public int getDepositamount() { return depositamount; }
    public void setDepositamount(int depositamount) { this.depositamount = depositamount; }

    private int delete_amount;
    public int getDelete_amount(){ return delete_amount;}
    public void setDelete_amount(int delete_amount){this.delete_amount=delete_amount;}


    String dept_desc;

    public String getDept_desc() {
        return dept_desc;
    }

    public void setDept_desc(String dept_desc) {
        this.dept_desc = dept_desc;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
    public Date getWhen() { return when; }
    public void setWhen(Date when) { this.when = when; }

}
