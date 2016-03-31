package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DomainStatusMatrixViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    PersonalComputerRepository repository;

    @RequestMapping("/domainStatusMatrix")
    public String getView(Model model, @AuthenticationPrincipal UserDetails userDetails){
        if (!security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        List<Object[]> data = repository.getDomainStausMatrix();
        model.addAttribute("data", data);
        logger.log("visited the Domain Status Matrix page");
        return "domainStatusMatrix";
    }

}
