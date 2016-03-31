package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PersonalComputerService;
import gr.mod.mil.stock.web.dto.DeletePcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DeletePersonalComputerViewController {

    @Autowired
    LogService logger;

    @Autowired
    PersonalComputerService service;

    @Autowired
    PersonalComputerRepository repository;

    @RequestMapping("/deletepc")
    public String getView(Model model, @RequestParam("id") String id){
        PersonalComputer computer = repository.findByPublicid(id);
        model.addAttribute("pc", computer);
        logger.log("visited the Delete Personal Computer Page for " + computer.getModelName());
        return "deletepc";
    }

    @RequestMapping(value = "/deletepc", method = RequestMethod.POST)
    public String doDelete(@ModelAttribute("deletePcDto") DeletePcDTO dto){
        service.delete(dto.getPublicid());
        logger.log("deleted the computer: " + dto.getPublicid());
        return "redirect:/pcs?deleted=true";
    }

}
