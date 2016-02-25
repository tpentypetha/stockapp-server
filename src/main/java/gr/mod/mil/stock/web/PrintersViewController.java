package gr.mod.mil.stock.web;

import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintersViewController {

    @Autowired
    PrinterRepository repo;

    @RequestMapping(value = "/printers", method = RequestMethod.GET)
    public String printers(Model model) {
        model.addAttribute("printers", repo.findAll());
        return "printers";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("printers", repo.findAll());
        return "printers";
    }

}
