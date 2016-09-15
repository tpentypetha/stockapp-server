package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Thl_Tmhma_Live;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Thl_TmhmaRepository extends CrudRepository<Thl_Tmhma_Live, Long> {

}
