package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.InkColor;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.web.dto.AddConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddConsumableViewController {

    @Autowired
    ConsumableService service;

    @RequestMapping(value = "/addConsumable", method = RequestMethod.GET)
    public String addConsumable() {
        return "addConsumable";
    }

    @RequestMapping(value="/addConsumable", method = RequestMethod.POST)
    public String receiveForm(@ModelAttribute("consumableDto") AddConsumableDTO data) {
        service.add(data.getCode(), InkColor.valueOf(data.getColor()), data.getCritical());
        return "redirect:consumables";
    }

}