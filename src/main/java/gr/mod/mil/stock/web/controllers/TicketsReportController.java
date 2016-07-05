package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.stock.Tickets;
import gr.mod.mil.stock.web.controllers.services.TicketsReportService;
import gr.mod.mil.stock.web.dto.GenericDateRangeDTO;
import gr.mod.mil.stock.web.dto.GenericTicketingRepDTO;
import gr.mod.mil.stock.web.dto.TicketingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TicketsReportController {
    @Autowired
    TicketsReportService service;


    @RequestMapping(value="/solvedtickets",  method = RequestMethod.GET)
    public String getView(@RequestParam(value = "error", required = false) boolean error,
            Model model) {

        model.addAttribute("error", error);
        return "solvedtickets";
    }



    @RequestMapping(value="/ticketsreport",  method = RequestMethod.POST)
    public String getView2(
            @ModelAttribute("ticketingReportDto")GenericTicketingRepDTO data,
            @RequestParam(value = "error", required = false) boolean error,
            Model model) {

        model.addAttribute("error", error);
        if(data.getFrom()=="" || data.getTo()==""){
            return "redirect:solvedtickets?error=true";
        }


        List<Tickets> tickets=service.getReport(data.getFromDate(),data.getToDate(),data.getOfficetxt(),data.getPhonetxt());
        model.addAttribute("tickets",tickets);

        return "solvedtickets";
    }
}
