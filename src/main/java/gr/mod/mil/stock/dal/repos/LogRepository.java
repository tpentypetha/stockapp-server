package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.LogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Long> {

}
