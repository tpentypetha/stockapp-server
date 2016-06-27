package gr.mod.mil.stock.web.controllers.computers;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.model.devices.PersonalComputerDomain;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FindComputerByDomainStatusViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    PersonalComputerRepository repository;

    @RequestMapping("/findByComputerDomainStatus")
    public String getView(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(value = "domain", required = false) String domain,
            @RequestParam(value = "status", required = false) String status){
        if (!security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        if (domain != null && status != null) {
            List<PersonalComputer> computers = repository.getComputerByDomainAndStatus(
                    PersonalComputerDomain.valueOf(domain),
                    DeviceStatus.valueOf(status));
            model.addAttribute("computers", computers);
        }
        logger.log("visited the Find Personal Computer By Domain and Status report page");
        return "findcomputers";
    }
}
