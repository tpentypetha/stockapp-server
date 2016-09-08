package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Thl_Persons;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Thl_PersonsRepository extends CrudRepository<Thl_Persons, Long> {

    @Query( "SELECT P " +
            "FROM Thl_Persons P ")
    List<Thl_Persons> getAll();

    @Query( "SELECT P " +
            "FROM Thl_Persons P "+
            "WHERE P.id=:id ")
   Thl_Persons getbyid(@Param("id") long id);


}
