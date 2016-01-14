package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumableRepository extends CrudRepository<Consumable, Long> {

    @Query("Select C from Consumable C where C.code like CONCAT('%', CONCAT(:code, '%') )")
    List<Consumable> findByCode(@Param("code") String code);

    Consumable findByPublicid(String publicid);

    @Query("Select C from Cabinet C, Quantity Q where Q MEMBER OF C.quantities AND Q.consumable.code = :code")
    List<Cabinet> getAvailability(@Param("code") String code);

}
