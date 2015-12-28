package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Quantity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuantityRepository extends CrudRepository<Quantity, Long> {

    Quantity findByPublicid(String publicid);

}
