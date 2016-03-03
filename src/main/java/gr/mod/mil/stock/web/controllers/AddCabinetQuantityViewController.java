package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.web.dto.AddQuantityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddCabinetQuantityViewController {

    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    ConsumableRepository consumableRepository;
    @Autowired
    QuantityService service;

    @RequestMapping(value = "/addCabinetQuantity", method = RequestMethod.GET)
    public String render(
            @RequestParam("cabinetid") String cabinetid,
            @RequestParam("consumableid") String consumableid,
            Model model){
        model.addAttribute("cabinet", cabinetRepository.findByPublicid(cabinetid));
        model.addAttribute("consumable", consumableRepository.findByPublicid(consumableid));
        return "addQuantity";
    }

    @RequestMapping(value = "/addCabinetQuantity", method = RequestMethod.POST)
    public String addQuantity(@ModelAttribute("addQuantityDto")AddQuantityDTO data){
        service.addQuantity(data.getCabinetid(), data.getConsumableid(), data.getQuantity());
        return "redirect:cabinet?id="+data.getCabinetid();
    }

}
