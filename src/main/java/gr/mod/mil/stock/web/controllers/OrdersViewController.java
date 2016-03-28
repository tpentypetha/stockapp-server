package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.OrderHistoryRepository;
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
public class OrdersViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    OrderHistoryRepository orders;

    @RequestMapping("/orders")
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(value = "from", required = false) String from,
            @RequestParam(value = "to", required = false) String to
            ){
        if (! security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        logger.log("visited the Orderes Report page");
        GenericDateRangeDTO dateRangeDTO = GenericDateRangeDTO.createDateRange(from, to);
        if (dateRangeDTO.isValid()){
            model.addAttribute("orders", orders.getOrdersFromTo(dateRangeDTO.getFromDate(), dateRangeDTO.getToDate()));
        }
        return "orders";
    }

}
