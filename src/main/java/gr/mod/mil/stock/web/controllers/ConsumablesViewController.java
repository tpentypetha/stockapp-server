package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.web.dto.SearchConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsumablesViewController {

    @Autowired
    ConsumableService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/consumables", method = RequestMethod.GET)
    public String consumables(@ModelAttribute("searchConsumableDto") SearchConsumableDTO data, Model model) {
        String input = data.getQuery() == null ? "" : data.getQuery().toLowerCase();
        model.addAttribute("consumables", service.searchByCode(input));
        logger.log("visited Consumables page");
        return "consumables";
    }
}
