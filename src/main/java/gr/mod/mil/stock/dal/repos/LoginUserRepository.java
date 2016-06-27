package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.system.Loginuser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginUserRepository extends CrudRepository<Loginuser, Long> {

    Loginuser findByUsername(String username);

    @Query( "SELECT L.username " +
            "FROM Loginuser L " )
    List<String> getAllUsers();

}
