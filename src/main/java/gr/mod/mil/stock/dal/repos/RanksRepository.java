package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Ranks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RanksRepository extends CrudRepository<Ranks, Long> {
}
