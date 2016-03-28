package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.model.devices.builders.PersonalComputerBuilder;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalComputerService {

    @Autowired
    PersonalComputerRepository repository;

    public PersonalComputer create(PersonalComputerBuilder builder){
        return repository.save(builder.createPersonalComputer());
    }

}
