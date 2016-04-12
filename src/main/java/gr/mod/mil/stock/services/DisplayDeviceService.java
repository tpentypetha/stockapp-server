package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.Display;
import gr.mod.mil.stock.dal.model.devices.builders.DisplayDeviceBuilder;
import gr.mod.mil.stock.dal.repos.DisplayDeviceRepository;
import gr.mod.mil.stock.web.dto.DisplayDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisplayDeviceService {

    @Autowired
    DisplayDeviceRepository repository;

    public Display create(DisplayDeviceBuilder builder) {
        return repository.save(builder.createDisplay());}

    public Display edit(DisplayDeviceDTO dto){
        Display display = repository.findByPublicid(dto.getPublicid());
        display.setSerialNum(dto.getSerialNum());
        display.setPartNum(dto.getPartNum());
        display.setPosition(dto.getPosition());
        display.setStatus(dto.getStatus());
        display.setInches(dto.getInches());
        display.setVga(dto.getVga());
        display.setDvi(dto.getDvi());
        display.setHdmi(dto.getHdmi());
        return repository.save(display);
    }

    public void delete(String publicid){
        repository.delete(repository.findByPublicid(publicid));
    }

}
