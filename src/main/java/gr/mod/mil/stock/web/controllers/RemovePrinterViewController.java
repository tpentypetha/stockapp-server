package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.Printer;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.RemovePrinterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemovePrinterViewController {

    @Autowired
    PrinterRepository repo;

    @Autowired
    PrinterService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/removePrinter", method = RequestMethod.GET)
    public String render(@RequestParam("id") String printerid, Model model){
        Printer printer = repo.findByPublicid(printerid);
        model.addAttribute("printer", printer);
        logger.log("visited Remove Printer page for " + printer.getName());
        return "removePrinter";
    }

    @RequestMapping(value="/removePrinter", method = RequestMethod.POST)
    public String remove(@ModelAttribute("removePrinterDto")RemovePrinterDTO data){
        Printer printer = repo.findByPublicid(data.getPrinterid());
        service.removePrinter(data.getPrinterid());
        logger.log("removed printer with name: " + printer.getName());
        return "redirect:printers";
    }

}
