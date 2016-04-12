package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Display;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisplayDeviceRepository extends CrudRepository <Display, Long >{

    Display findByPublicid(String publicid);
}
