package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.Printer;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.printer.RemovePrinterConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RemovePrinterConsumableController {

    @Autowired
    PrinterService service;

    @Autowired
    PrinterRepository printers;

    @Autowired
    ConsumableRepository repository;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/removePrinterConsumable",method = RequestMethod.POST)
    public String doRemove(@ModelAttribute("removePrinterConsumableDto")RemovePrinterConsumableDTO data){
        Printer printer = printers.findByPublicid(data.getPrinterid());
        Consumable consumable = repository.findByPublicid(data.getConsumableid());
        service.removeConsumable(data.getPrinterid(), data.getConsumableid());
        logger.log("removed the consumable " + consumable.getCode() + "("+data.getConsumableid()+") from printer: " + printer.getName());
        return "redirect:printer?id="+data.getPrinterid();
    }

}
