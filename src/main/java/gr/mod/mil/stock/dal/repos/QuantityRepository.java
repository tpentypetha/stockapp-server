package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Quantity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuantityRepository extends CrudRepository<Quantity, Long> {

    Quantity findByPublicid(String publicid);

    @Query( "SELECT SUM(Q.amount) " +
            "FROM Quantity Q " +
            "WHERE Q.consumable.id = :id")
    long getCurrentSupply(@Param("id") long id);

    @Query( "SELECT Q.consumable.id, SUM(Q.amount) " +
            "FROM Quantity Q " +
            "GROUP BY Q.consumable.id")
    List<Object[]> getAllCurrentSupplies();



}
