package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.CabinetService;
import gr.mod.mil.stock.web.dto.RemoveCabinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveCabinetViewController {

    @Autowired
    CabinetRepository repository;

    @Autowired
    CabinetService service;

    @RequestMapping("/removeCabinet")
    public String viewPage(@RequestParam("id") String id, Model model){
        model.addAttribute("cabinet", repository.findByPublicid(id));
        return "removeCabinet";
    }

    @RequestMapping(value = "/removeCabinet", method = RequestMethod.POST)
    public String doRemove(@ModelAttribute("removeCabinetDto")RemoveCabinetDTO data) {
        service.removeCabinet(data.getCabinetid());
        return "redirect:cabinets";
    }

}
