package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowAvailableViewController {

    @Autowired
    ConsumableService service;

    @Autowired
    ConsumableRepository repository;

    @Autowired
    LogService logger;

    @RequestMapping("/showAvailable")
    public String viewPage(@RequestParam("id") String consumableid, Model model) {
        Consumable consumable = repository.findByPublicid(consumableid);
        model.addAttribute("availabilities", service.getAvailable(consumableid));
        model.addAttribute("consumable", consumable);
        logger.log("visited the Availability page for consumable: " + consumable.getCode());
        return "showAvailable";
    }

}
