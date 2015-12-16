package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinetRepository extends CrudRepository<Cabinet, Long> {

    @Query("SELECT C from Cabinet C where LOWER(C.name) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<Cabinet> findByName(@Param("input") String name);

    @Query("SELECT C.contains from Cabinet C left join C.contains as T where C.id = :cabinetId")
    List<Consumable> getCabinetConsumables(@Param("cabinetId") long id);

    Cabinet findByPublicid(String publicid);

}
