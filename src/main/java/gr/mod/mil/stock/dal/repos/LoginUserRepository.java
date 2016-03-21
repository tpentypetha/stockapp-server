package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.Loginuser;
import org.springframework.data.repository.CrudRepository;

public interface LoginUserRepository extends CrudRepository<Loginuser, Long> {

    public Loginuser findByUsername(String username);

}
