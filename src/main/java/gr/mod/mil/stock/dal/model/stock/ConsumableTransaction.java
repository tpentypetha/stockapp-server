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

    @Temporal(TemporalType.TIMESTAMP)
    private Date when;
    public Date getWhen() { return when; }
    public void setWhen(Date when) { this.when = when; }

}
