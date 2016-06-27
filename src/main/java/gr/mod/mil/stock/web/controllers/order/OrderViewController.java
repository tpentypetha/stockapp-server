package gr.mod.mil.stock.web.controllers.order;

import gr.mod.mil.stock.dal.model.ordering.OrderHistory;
import gr.mod.mil.stock.dal.model.ordering.Order;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.OrderingService;
import gr.mod.mil.stock.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class OrderViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    Order order;

    @Autowired
    OrderingService service;

    @RequestMapping("/order")
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails){
        if (! security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        model.addAttribute("order", order);
        logger.log("visited Order page");
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String saveAndPrint(@AuthenticationPrincipal UserDetails userDetails){
        if(! security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        OrderHistory history = service.saveCurrentOrder();
        logger.log("saved an Order at: " + new Date().toString());
        return "redirect:/orderhistory?saved=true&historyid="+history.getPublicid();
    }

    @RequestMapping("/order/remove")
    public String removeItem(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("title") String title
    ){
        if (!security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        order.removeItemByTitle(title);
        logger.log("removed an item from the order with title: " + title);
        return "redirect:/order";
    }

}
