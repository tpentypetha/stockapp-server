package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.system.LogEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Long> {

    @Query("SELECT E " +
            "FROM LogEntry E " +
            "WHERE E.who = :username " +
            "AND E.when BETWEEN :from AND :to " +
            "ORDER BY E.when ")
    List<LogEntry> getLogEntriesFor(
            @Param("username")String user,
            @Param("from") Date from,
            @Param("to") Date to);

    @Query( "SELECT E " +
            "FROM LogEntry E " +
            "WHERE E.when BETWEEN :from AND :to " +
            "ORDER BY E.when")
    List<LogEntry> getLogEntries(
            @Param("from") Date from,
            @Param("to") Date to);
}
