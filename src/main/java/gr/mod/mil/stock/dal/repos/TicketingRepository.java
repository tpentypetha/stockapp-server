package gr.mod.mil.stock.dal.repos;


import gr.mod.mil.stock.dal.model.stock.Tickets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketingRepository extends CrudRepository<Tickets, Long> {


    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Σε αναμονή'")
    List<Tickets> getPending();

    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.id = :id")
    Tickets findbyId(@Param("id") long id);

}
