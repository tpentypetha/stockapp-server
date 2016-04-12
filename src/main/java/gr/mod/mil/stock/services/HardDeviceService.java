package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.HardDrive;
import gr.mod.mil.stock.dal.model.devices.builders.HardDeviceBuilder;
import gr.mod.mil.stock.dal.repos.HardDeviceRepository;
import gr.mod.mil.stock.web.dto.HardDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HardDeviceService {

    @Autowired
    HardDeviceRepository repository;

    public HardDrive create(HardDeviceBuilder builder){
        return repository.save(builder.createHardDrive());
    }

    public HardDrive edit(HardDeviceDTO dto){
        HardDrive hardDrive = repository.findByPublicid(dto.getPublicid());
        hardDrive.setSerialNum(dto.getSerialNum());
        hardDrive.setPartNum(dto.getPartNum());
        hardDrive.setPosition(dto.getPosition());
        hardDrive.setStatus(dto.getStatus());
        hardDrive.setCapacity(dto.getCapacity());
        hardDrive.setTechnology(dto.getTechnology());
        hardDrive.setSocket(dto.getSocket());
        return repository.save(hardDrive);
    }
    public void delete(String publicid){
        repository.delete(repository.findByPublicid(publicid));
    }

}
