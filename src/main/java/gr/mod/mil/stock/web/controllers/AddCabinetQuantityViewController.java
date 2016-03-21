package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.Quantity;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.web.dto.AddQuantityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddCabinetQuantityViewController {

    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    ConsumableRepository consumableRepository;
    @Autowired
    QuantityService service;
    @Autowired
    LogService logger;

    @RequestMapping(value = "/addCabinetQuantity", method = RequestMethod.GET)
    public String render(
            @RequestParam("cabinetid") String cabinetid,
            @RequestParam("consumableid") String consumableid,
            Model model){
        model.addAttribute("cabinet", cabinetRepository.findByPublicid(cabinetid));
        model.addAttribute("consumable", consumableRepository.findByPublicid(consumableid));
        logger.log("visited Add Cabinet page");
        return "addQuantity";
    }

    @RequestMapping(value = "/addCabinetQuantity", method = RequestMethod.POST)
    public String addQuantity(
            @ModelAttribute("addQuantityDto")AddQuantityDTO data){
        Cabinet cabinet = cabinetRepository.findByPublicid(data.getCabinetid());
        Consumable consumable = consumableRepository.findByPublicid(data.getConsumableid());
        try {
            service.addQuantity(data.getCabinetid(), data.getConsumableid(), data.getQuantity());
            logger.log("added " + data.getQuantity() + " of consumable: " + consumable.getCode() + " " + consumable.getColor() + " to cabinet: " + cabinet.getName());
            return "redirect:cabinet?id="+data.getCabinetid();
        } catch (QuantityService.ConsumableQuantityAlreadyExists cqae) {
            return "redirect:addCabinetConsumable?cabinetid="+cabinet.getPublicid()+"&error=true";
        }
    }

}
