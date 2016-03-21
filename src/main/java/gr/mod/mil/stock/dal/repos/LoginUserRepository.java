package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Loginuser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginUserRepository extends CrudRepository<Loginuser, Long> {

    Loginuser findByUsername(String username);

}
