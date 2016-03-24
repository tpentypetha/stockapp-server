package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.OrderedItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemRepository extends CrudRepository<OrderedItem, Long> {

}
