package gr.mod.mil.stock.web.controllers.consumables;

import gr.mod.mil.stock.dal.model.stock.InkColor;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.web.dto.consumable.AddConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddConsumableViewController {

    @Autowired
    ConsumableService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/addConsumable", method = RequestMethod.GET)
    public String addConsumable(@RequestParam(value = "error", required = false) boolean error,
                                Model model){
        model.addAttribute("error", error);

        return "addConsumable";
    }

    @RequestMapping(value="/addConsumable", method = RequestMethod.POST)
    public String receiveForm(@ModelAttribute("consumableDto") AddConsumableDTO data,
                              @RequestParam(value = "error", required = false) boolean error,
                              Model model) {
        model.addAttribute("error", error);

        try {
            service.add(data.getCode(), InkColor.valueOf(data.getColor()), data.getCritical());

            logger.log("added a consumable with code: " + data.getCode());
            return "redirect:consumables";
        } catch (ConsumableService.ConsumableAlreadyExists e) {

            return "redirect:addConsumable?error=true";
        }
    }

}
