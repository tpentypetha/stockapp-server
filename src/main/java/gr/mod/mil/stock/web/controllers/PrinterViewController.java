package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.PrinterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrinterViewController {

    @Autowired
    PrinterRepository repo;

    @RequestMapping(value = "/printer", method = RequestMethod.GET)
    public String printer(@RequestParam("id") String id, Model model) {
        model.addAttribute("printer", repo.findByPublicid(id));
        return "printer";
    }

}
