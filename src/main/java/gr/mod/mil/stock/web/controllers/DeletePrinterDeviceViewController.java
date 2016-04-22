package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.dal.repos.PrinterDeviceRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterDeviceService;
import gr.mod.mil.stock.web.dto.DeletePrinterDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeletePrinterDeviceViewController {

    @Autowired
    LogService logger;

    @Autowired
    PrinterDeviceService service;

    @Autowired
    PrinterDeviceRepository repository;

    @RequestMapping("/deletePrinterDevice")
    public String getView(Model model, @RequestParam("id") String id){
        PrinterDevice printer = repository.findByPublicid(id);
        model.addAttribute("printer", printer);
        logger.log("visited the Delete Printer Device Page for " + printer.getModelName());
        return "deletePrinterDevice";
    }

    @RequestMapping(value = "/deletePrinterDevice", method = RequestMethod.POST)
    public String doDelete(@ModelAttribute("deletePrinterDeviceDto") DeletePrinterDeviceDTO dto){
        service.delete(dto.getPublicid());
        logger.log("deleted the Printer Device: " + dto.getPublicid());
        return "redirect:/printerDevices?deleted=true";
    }

}
