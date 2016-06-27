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
        return repository.save(builder.createPersonalComputer());
    }

    public PersonalComputer edit(EditPcDTO dto){
        PersonalComputer computer = repository.findByPublicid(dto.getPublicid());
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
        return repository.save(computer);
    }

    public void delete(String publicid){
        repository.delete(repository.findByPublicid(publicid));
    }

}
