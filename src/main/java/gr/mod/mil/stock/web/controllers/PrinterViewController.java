package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.stock.Printer;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrinterViewController {

    @Autowired
    PrinterRepository repo;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/printer", method = RequestMethod.GET)
    public String printer(
            @RequestParam("id") String id,
            @RequestParam(value = "error", required = false) boolean error,
            Model model) {
        Printer printer = repo.findByPublicid(id);
        model.addAttribute("error", error);
        model.addAttribute("printer", printer);
        logger.log("visited " + printer.getName() + " printer's page");
        return "printer";
    }

}
