package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.KeyboardVideoMouse;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryLookupStrategy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KvmRepository extends CrudRepository<KeyboardVideoMouse, Long> {

    @Query("SELECT P from KeyboardVideoMouse P WHERE P.PUBLICID LIKE CONCAT('%', CONCAT(:pid, '%') )")
    KeyboardVideoMouse findByPublicid(@Param("pid") String publicid);

    @Query("SELECT P from KeyboardVideoMouse P where LOWER(P.model_name) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<KeyboardVideoMouse> findByName(@Param("input") String model_name);

    @Query("SELECT P from KeyboardVideoMouse P where P.belongs_to= :belongs_to")
    List<KeyboardVideoMouse> getKvms_ThatBelongsTo(@Param("belongs_to") long id);

}
