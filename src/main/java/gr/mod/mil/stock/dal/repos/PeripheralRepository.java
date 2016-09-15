package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Peripheral;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeripheralRepository extends CrudRepository<Peripheral, Long> {

    @Query("SELECT P from Peripheral P WHERE P.publicid=:publicid ")
    Peripheral findByPublicid(@Param("publicid") String publicid);

    @Query("SELECT P from Peripheral P where LOWER(P.type) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<Peripheral> findByType(@Param("input") String type);

    @Query("SELECT P from Peripheral P where  P.belongs_to= :belongs_to")
    List<Peripheral> getPeripheralsThat_BelongsTo(@Param("belongs_to") long id);
}
