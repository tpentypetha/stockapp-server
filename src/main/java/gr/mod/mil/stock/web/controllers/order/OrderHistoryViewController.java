package gr.mod.mil.stock.web.controllers.order;

import gr.mod.mil.stock.dal.model.ordering.OrderHistory;
import gr.mod.mil.stock.dal.repos.OrderHistoryRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.controllers.services.OrderingControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class OrderHistoryViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    OrderHistoryRepository repository;

    @Autowired
    OrderingControllerService service;

    @RequestMapping("/orderhistory")
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(value = "saved", required = false) boolean saved,
            @RequestParam("historyid") String historyid) {
        if (!security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        model.addAttribute("saved", saved);
        model.addAttribute("order", repository.findByPublicid(historyid));
        return "orderhistory";
    }

    @RequestMapping("/printorder")
    public void print(
            @RequestParam("id") String id,
            HttpServletResponse response){
        OrderHistory history = repository.findByPublicid(id);
        try {
            service.downloadPDF(history, response);
        } catch(IOException ioe) {
            throw new RuntimeException("Could not print order.");
        }
    }

}
