package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CabinetViewController {

    @Autowired
    CabinetRepository repo;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String render(@RequestParam("id") String cabinetid, Model model){
        model.addAttribute("cabinet", repo.findByPublicid(cabinetid));
        return "cabinet";
    }

}
