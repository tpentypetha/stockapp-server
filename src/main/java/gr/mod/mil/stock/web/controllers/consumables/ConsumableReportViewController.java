package gr.mod.mil.stock.web.controllers.consumables;

import gr.mod.mil.stock.services.ConsumableTransactionsService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrintReportService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.consumable.GenericConsumableReportRow;
import gr.mod.mil.stock.web.dto.GenericDateRangeDTO;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@Controller
public class ConsumableReportViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    PrintReportService print;

    @Autowired
    ConsumableTransactionsService service;

    @RequestMapping("/consumableReports")
    public String view(@AuthenticationPrincipal UserDetails user,
                       @RequestParam(value = "error", required = false) boolean error,
                       @ModelAttribute("consumableReportDto")GenericDateRangeDTO data,
                       Model model){
        model.addAttribute("error", error);
        model.addAttribute("data", data);
        if (! security.isAuthorizedAsAdmin(user)){
            return "redirect:/?notAdmin=true";
        }

        logger.log("visited Consumable Reports page");
        return "consumableReports";
    }





    @RequestMapping(value = "/printRep", method = RequestMethod.POST)
    public void printview(
            @AuthenticationPrincipal UserDetails user,
            @ModelAttribute("data")GenericDateRangeDTO data,
            @RequestParam(value = "from") String from,
            @RequestParam(value = "error", required = false) boolean error,
            HttpServletResponse response,
            Model model){
        model.addAttribute("error", error);
        if (! security.isAuthorizedAsAdmin(user)){

        }
        Date f=data.getFromDate();

       byte[] pdf= print.PrintRep(data.getQuantity1(),data.getQuantity2(),data.getQuantity3(),data.getFromDate(),data.getToDate());
        InputStream is = new ByteArrayInputStream(pdf);

        response.addHeader("Content-Type", "application/force-download");
        String name = "Report_"+data.getFrom().replace(' ','_')+".pdf";
        response.addHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
        try {
            IOUtils.copy(is, response.getOutputStream());
        } catch (IOException e) {
           ;
        }

    }

    @RequestMapping(value = "/consumableReports", method = RequestMethod.POST)
    public String doReport(
            @AuthenticationPrincipal UserDetails user,
            @ModelAttribute("consumableReportDto")GenericDateRangeDTO data,
            @RequestParam(value = "error", required = false) boolean error,
            Model model){
        model.addAttribute("error", error);
        if (! security.isAuthorizedAsAdmin(user)){
            return "redirect:/?notAdmin=true";
        }

        if(data.getFrom()=="" || data.getTo()==""){
            return "redirect:consumableReports?error=true";
        }

        List<GenericConsumableReportRow> rows = service.getConcetratedReport(data.getFromDate(), data.getToDate(),
                data.getQuantity1(),data.getQuantity2(),data.getQuantity3());
        model.addAttribute("rows", rows);
        model.addAttribute("data", data);
        return "consumableReports";
    }

}
