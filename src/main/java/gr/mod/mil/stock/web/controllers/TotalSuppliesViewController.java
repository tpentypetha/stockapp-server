package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.ConsumableTransactionsService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.GenericConsumableReportRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TotalSuppliesViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService securityService;

    @Autowired
    ConsumableTransactionsService service;

    @RequestMapping("/totalSupplies")
    public String view(@AuthenticationPrincipal UserDetails userDetails, Model model){
        if (!securityService.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        List<GenericConsumableReportRow> rows = service.getTotalSupplies();
        model.addAttribute("rows", rows);
        logger.log("visited the Total Supplies Report page");
        return "totalSupplies";
    }

}
