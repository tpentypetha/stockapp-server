package gr.mod.mil.stock.web.controllers.computers;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PersonalComputerService;
import gr.mod.mil.stock.web.dto.computer.EditPcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditPersonalComputerViewController {

    @Autowired
    LogService logger;

    @Autowired
    PersonalComputerRepository repository;

    @Autowired
    PersonalComputerService service;

    @RequestMapping("/editpc")
    public String view(Model model, @RequestParam("id") String id) {
        model.addAttribute("pc", repository.findByPublicid(id));
        logger.log("visited the edit Personal Computer page");
        return "editpc";
    }

    @RequestMapping(value = "/editpc", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editPcDto")EditPcDTO data){
        PersonalComputer edited  = service.edit(data);
        logger.log("edited a Personal Computer with id: " + edited.getPublicid());
        return "redirect:/pcs?query="+edited.getPublicid();
    }

}
