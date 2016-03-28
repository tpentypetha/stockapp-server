package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CabinetRepository extends CrudRepository<Cabinet, Long> {

    @Query("SELECT C from Cabinet C where LOWER(C.name) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<Cabinet> findByName(@Param("input") String name);

    Cabinet findByPublicid(String publicid);

}
