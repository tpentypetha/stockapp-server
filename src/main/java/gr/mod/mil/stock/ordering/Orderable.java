package gr.mod.mil.stock.ordering;

import java.io.Serializable;

public interface Orderable extends Serializable{

    String getOrderableTitle();

    OrderableCategory getCategory();

}
