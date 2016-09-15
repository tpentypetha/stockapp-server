package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.model.devices.builders.PersonalComputerBuilder;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.web.dto.computer.EditPcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalComputerService {

    @Autowired
    PersonalComputerRepository repository;

    public PersonalComputer create(PersonalComputerBuilder builder){

        // me tin entoli builder.createPersonalComputer()  dimiourgoume to object  PersonalComputer kai stin sinexeia kanoume isert stin
        // database xrisimopoiontas tin entoli save tou repository me parametro to Oject pou dimiourgisame (PersonalComputer)
        return repository.save(builder.createPersonalComputer());
    }

    public PersonalComputer edit(EditPcDTO dto){

        PersonalComputer computer = repository.getByPublicid(dto.getPublicid()); // Vriskoume to computer me vasi to publicid tou apo to PersonalComputerRepository


        // stin sinexeia kanoume tis epithimites allages stin sigkekrimeni eggrafi
        computer.setSerialNum(dto.getSerialNum());
        computer.setPartNum(dto.getPartNum());
        computer.setPosition(dto.getPosition());
        computer.setStatus(dto.getStatus());
        computer.setRam(dto.getRam());
        computer.setMemory(dto.getMemory());
        computer.setCpu(dto.getCpu());
        computer.setCpuSocket(dto.getCpuSocket());
        computer.setCaseType(dto.getCaseType());
        computer.setDomain(dto.getDomain());
        return repository.save(computer); // kai telos me tin entoli repository.save(computer) kanoume update stin database
    }

    public void delete(String publicid){
        repository.delete(repository.getByPublicid(publicid));
    }

}
