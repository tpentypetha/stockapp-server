package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeViewController {

    @Autowired
    LogService logger;

    @RequestMapping("/")
    public String render(@RequestParam(value = "notAdmin", required = false) boolean notAdmin, Model model){
        logger.log("visited Home page");
        model.addAttribute("notAdmin", notAdmin);
        return "home";
    }
}
