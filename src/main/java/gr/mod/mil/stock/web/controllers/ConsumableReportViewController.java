package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.ConsumableTransactionsService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.GenericConsumableReportRow;
import gr.mod.mil.stock.web.dto.ConsumableReportDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ConsumableReportViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    ConsumableTransactionsService service;

    @RequestMapping("/consumableReports")
    public String view(@AuthenticationPrincipal UserDetails user){
        if (! security.isAuthorizedAsAdmin(user)){
            return "redirect:/?notAdmin=true";
        }
        logger.log("visited Consumable Reports page");
        return "consumableReports";
    }

    @RequestMapping(value = "/consumableReports", method = RequestMethod.POST)
    public String doReport(
            @AuthenticationPrincipal UserDetails user,
            @ModelAttribute("consumableReportDto")ConsumableReportDto data,
            Model model){
        if (! security.isAuthorizedAsAdmin(user)){
            return "redirect:/?notAdmin=true";
        }
        List<GenericConsumableReportRow> rows = service.getConcetratedReport(data.getFromDate(), data.getToDate());
        model.addAttribute("rows", rows);
        return "consumableReports";
    }

}
