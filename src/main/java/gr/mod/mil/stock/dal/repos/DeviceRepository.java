package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.Device;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface DeviceRepository<T extends Device, E extends Serializable> extends CrudRepository<T,E> {

}
