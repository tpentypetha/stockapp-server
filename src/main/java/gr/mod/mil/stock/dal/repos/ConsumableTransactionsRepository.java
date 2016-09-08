package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.stock.ConsumableTransaction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ConsumableTransactionsRepository extends CrudRepository<ConsumableTransaction, Long> {

    @Query( "SELECT T.consumable.id, SUM(T.withdrawamount), SUM(T.depositamount)- SUM(T.delete_amount) " +
            "FROM ConsumableTransaction T " +
            "WHERE T.when BETWEEN :from AND :to  " +
            "GROUP BY T.consumable.id")
    List<Object[]> getTransactions(@Param("from") Date from, @Param("to") Date to);



}



