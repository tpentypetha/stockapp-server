package gr.mod.mil.stock.dal.model.ordering;

import java.io.Serializable;

public interface Orderable extends Serializable{

    String getOrderableTitle();

    OrderableCategory getCategory();

}
