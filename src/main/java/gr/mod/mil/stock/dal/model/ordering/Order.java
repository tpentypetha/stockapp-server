package gr.mod.mil.stock.dal.model.ordering;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Order {

    private long id;
    public long getId() { return id; }
    public void setId(long id) {this.id = id;}

    private final Map<Orderable, Integer> items;
    public Map<Orderable, Integer> getItems() { return items; }

    public Order(){
        this.items = new HashMap<>();
    }

    public void appendItem(Orderable orderable, int amount){
        if (items.containsKey(orderable)) {
            items.put(orderable, items.get(orderable) + amount);
        } else {
            items.put(orderable, amount);
        }
    }

    public void removeItemByTitle(String title) {
        OrderedItem criteria = new OrderedItem();
        criteria.setOrderableTitle(title);

        if (items.containsKey(criteria)){
            items.remove(criteria);
        } else {
            throw new OrderStateException();
        }
    }

    public void clear() {
        items.clear();
    }

    public class OrderStateException extends RuntimeException {
        public OrderStateException(){
            super("The order is not in a proper state.");
        }
    }

}
