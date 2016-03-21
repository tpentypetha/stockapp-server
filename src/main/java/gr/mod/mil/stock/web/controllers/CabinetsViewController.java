package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CabinetsViewController {

    @Autowired
    CabinetRepository repo;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/cabinets", method = RequestMethod.GET)
    public String index(@RequestParam(value = "name", required = false) String name, Model model) {
        String input = name == null ? "" : name.toLowerCase();
        model.addAttribute("cabinets", repo.findByName(input));
        logger.log("visited Cabinets page");
        return "cabinets";
    }

}
