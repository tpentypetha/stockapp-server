package gr.mod.mil.stock.dal.repos;


import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalComputerRepository extends DeviceRepository<PersonalComputer, Long> {

}
