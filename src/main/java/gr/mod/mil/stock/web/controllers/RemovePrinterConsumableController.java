package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.RemovePrinterConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RemovePrinterConsumableController {

    @Autowired
    PrinterService service;

    @RequestMapping(value = "/removePrinterConsumable",method = RequestMethod.POST)
    public String doRemove(@ModelAttribute("removePrinterConsumableDto")RemovePrinterConsumableDTO data){
        service.removeConsumable(data.getPrinterid(), data.getConsumableid());
        return "redirect:printer?id="+data.getPrinterid();
    }

}
