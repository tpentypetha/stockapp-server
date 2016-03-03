package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.PrinterRepository;
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

    @RequestMapping(value = "/removePrinter", method = RequestMethod.GET)
    public String render(@RequestParam("id") String printerid, Model model){
        model.addAttribute("printer", repo.findByPublicid(printerid));
        return "removePrinter";
    }

    @RequestMapping(value="/removePrinter", method = RequestMethod.POST)
    public String remove(@ModelAttribute("removePrinterDto")RemovePrinterDTO data){
        service.removePrinter(data.getPrinterid());
        return "redirect:printers";
    }

}
