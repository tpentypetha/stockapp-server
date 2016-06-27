package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.dal.model.devices.builders.PrinterDeviceBuilder;
import gr.mod.mil.stock.dal.repos.PrinterDeviceRepository;
import gr.mod.mil.stock.web.dto.printer.EditPrinterDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrinterDeviceService {

    @Autowired
    PrinterDeviceRepository repository;

    public PrinterDevice create(PrinterDeviceBuilder builder){
        return repository.save(builder.createPrinterDevice());
    }

    public PrinterDevice edit(EditPrinterDeviceDTO dto){
        PrinterDevice printer = repository.findByPublicid(dto.getPublicid());
        printer.setSerialNum(dto.getSerialNum());
        printer.setPartNum(dto.getPartNum());
        printer.setPosition(dto.getPosition());
        printer.setStatus(dto.getStatus());
        printer.setTechnology(dto.getTechnology());
        printer.setNetworkPrinter(dto.getNetworkPrinter());
        printer.setColorPrinter(dto.getColorPrinter());
        printer.setMultiPurposeMachine(dto.getMultiPurposeMachine());
        return repository.save(printer);
    }
    public void delete(String publicid){
        repository.delete(repository.findByPublicid(publicid));
    }

}