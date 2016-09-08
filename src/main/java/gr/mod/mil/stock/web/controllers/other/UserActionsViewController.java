package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.dal.repos.LogRepository;
import gr.mod.mil.stock.dal.repos.LoginUserRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.GenericDateRangeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserActionsViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    LoginUserRepository users;

    @Autowired
    LogRepository logs;

    @RequestMapping("/loginuserReports")
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(value = "username", required = false) String username,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to){
        if (!security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        model.addAttribute("users", users.findAll());
        GenericDateRangeDTO dateRangeDTO = GenericDateRangeDTO.createDateRange(from, to);
        if (dateRangeDTO.isValid() && username != null){
            model.addAttribute("entries", logs.getLogEntriesFor(username, dateRangeDTO.getFromDate(), dateRangeDTO.getToDate()));
        }
        return "useractions";
    }
}
