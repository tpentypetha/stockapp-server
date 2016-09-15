package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.services.ConsumableTransactionsService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.consumable.GenericConsumableReportRow;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
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

    @RequestMapping("/printtotalSupplies")
    public void printrep(@AuthenticationPrincipal UserDetails userDetails, HttpServletResponse response, Model model){

        List<GenericConsumableReportRow> rows = service.getTotalSupplies();
        byte[] pdf= service.printReport(rows);

        response.addHeader("Content-Type", "application/force-download");
        String name = "Total_Supplies_Report_"+".pdf";
        response.addHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
        InputStream is = new ByteArrayInputStream(pdf);
        try {
            IOUtils.copy(is, response.getOutputStream());
        } catch (IOException e) {
            ;
        }


    }

}
