package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalComputerViewController {

    @Autowired
    LogService logger;

    @Autowired
    PersonalComputerRepository repository;

    @RequestMapping("/pcs")
    public String view(Model model, @RequestParam(value = "query", required = false) String query){
        if(query != null && ! query.isEmpty()) {
            model.addAttribute("pcs", repository.findByPublicid(query));
        }
        logger.log("visited the Personal Computer page");
        return "pcs";
    }

}
