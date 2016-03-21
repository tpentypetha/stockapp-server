package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddCabinetConsumableViewController {

    @Autowired
    CabinetRepository repo;

    @Autowired
    ConsumableRepository consumables;

    @Autowired
    LogService logger;

    @RequestMapping("/addCabinetConsumable")
    public String render(
            @RequestParam(value = "error", required = false) boolean error,
            @RequestParam("cabinetid") String cabinetid,
            @RequestParam(value = "code", required = false) String code,
            Model model){
        logger.log("visited Add Consumable page");
        model.addAttribute("error", error);
        model.addAttribute("cabinet", repo.findByPublicid(cabinetid));
        model.addAttribute("consumables", getConsumables(code));
        return "addCabinetConsumable";
    }

    private List<Consumable> getConsumables(String code){
        if (code == null || code.trim().equals("")) {
            return new ArrayList<>();
        } else {
            return consumables.findByCode(code.toLowerCase());
        }
    }

}
