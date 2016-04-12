package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.HardDrive;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HardDeviceRepository extends CrudRepository <HardDrive,Long> {

    HardDrive findByPublicid(String publicid);
}
