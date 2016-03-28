package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.ordering.OrderHistory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderHistoryRepository extends CrudRepository<OrderHistory, Long> {

    OrderHistory findByPublicid(String publicid);

    @Query("SELECT O " +
            "FROM OrderHistory O " +
            "WHERE O.when BETWEEN :from AND :to " +
            "ORDER BY O.when DESC")
    List<OrderHistory> getOrdersFromTo(@Param("from")Date from, @Param("to")Date to);

}
