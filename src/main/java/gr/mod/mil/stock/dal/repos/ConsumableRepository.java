package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.model.stock.Consumable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsumableRepository extends CrudRepository<Consumable, Long> {

    @Query("Select C from Consumable C where LOWER(C.code) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<Consumable> findByCode(@Param("input") String code);

    @Query("Select C from Consumable C where LOWER(C.code) = TRIM(LOWER(:input))  ")
    List<Consumable> ConsumableAllreadyExists(@Param("input") String code);

    Consumable findByPublicid(String publicid);

    @Query("Select C from Cabinet C, Quantity Q where Q MEMBER OF C.quantities AND Q.consumable.code = :code")
    List<Cabinet> getAvailability(@Param("code") String code);

}
