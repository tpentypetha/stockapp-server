package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.OrderHistory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {

    OrderHistory findByPublicid(String publicid);

}
