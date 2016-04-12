package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrinterDeviceRepository extends CrudRepository<PrinterDevice, Long>{

    PrinterDevice findByPublicid(String publicid);

}
