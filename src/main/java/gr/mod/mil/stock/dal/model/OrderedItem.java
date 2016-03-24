package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.mod.mil.stock.ordering.Orderable;
import gr.mod.mil.stock.ordering.OrderableCategory;

import javax.persistence.*;

@Entity
public class OrderedItem implements Orderable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private long id;
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    private String orderableTitle;
    public String getOrderableTitle() {
        return orderableTitle;
    }
    public void setOrderableTitle(String title) {
        this.orderableTitle = title;
    }

    @Enumerated(EnumType.STRING)
    private OrderableCategory category;
    public OrderableCategory getCategory() {
        return category;
    }
    public void setCategory(OrderableCategory category) {
        this.category = category;
    }

    private int finalAmount;
    public int getFinalAmount() { return  finalAmount; }
    public void setFinalAmount(int finalAmount) { this.finalAmount = finalAmount; }

    @Override
    public int hashCode() {
        return this.getOrderableTitle().hashCode();
    }

    @Override
    public boolean equals(Object other) {
        return other instanceof OrderedItem && ((OrderedItem)other).orderableTitle.equals(this.getOrderableTitle());
    }

    public static OrderedItem getItemFrom(String title, String category) {
        OrderedItem item = new OrderedItem();
        item.setOrderableTitle(title);
        item.setCategory(OrderableCategory.valueOf(category));
        return item;
    }
}
