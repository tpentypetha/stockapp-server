package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.LogRepository;
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
public class LogViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    LogRepository logs;

    @RequestMapping("/log")
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails details,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to){
        if(!security.isAuthorizedAsAdmin(details)){
            return "redirect:/?notAdmin=true";
        }
        GenericDateRangeDTO dateRangeDTO = GenericDateRangeDTO.createDateRange(from, to);
        if (dateRangeDTO.isValid()) {
            model.addAttribute("entries", logs.getLogEntries(dateRangeDTO.getFromDate(), dateRangeDTO.getToDate()));
        }
        logger.log("visited the Logs View Page");
        return "logs";
    }

}
