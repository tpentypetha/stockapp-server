package gr.mod.mil.stock.dal.repos;


import gr.mod.mil.stock.dal.model.stock.Tickets;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
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

    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Επιλύθηκε' AND T.datein BETWEEN :from AND :to AND T.phone = :phonetxt  AND T.office = :officetxt ")
    List<Tickets> getTicketsReport(@Param("from") Date from, @Param("to") Date to, @Param("officetxt") String officetxt,@Param("phonetxt") String phonetxt);

    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Επιλύθηκε' AND T.datein BETWEEN :from AND :to AND T.phone = :phonetxt ")
    List<Tickets> getTicketsReportwithoutoffice(@Param("from") Date from, @Param("to") Date to,@Param("phonetxt") String phonetxt);

    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Επιλύθηκε' AND T.datein BETWEEN :from AND :to AND T.office = :officetxt ")
    List<Tickets> getTicketsReportwithoutphone(@Param("from") Date from, @Param("to") Date to, @Param("officetxt") String officetxt);

    @Query( "SELECT T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Επιλύθηκε' AND T.datein BETWEEN :from AND :to ")
    List<Tickets> getTicketsReportwithoutall(@Param("from") Date from, @Param("to") Date to);


    @Query( "SELECT  T " +
            "FROM Tickets T " +
            "WHERE T.status = 'Επιλύθηκε' AND rownum <=10"+
            "ORDER BY T.datein DESC "
            )
    List<Tickets> getlast10Solved();


}
