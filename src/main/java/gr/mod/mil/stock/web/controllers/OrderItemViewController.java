package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.QuantityRepository;
import gr.mod.mil.stock.ordering.Order;
import gr.mod.mil.stock.dal.model.OrderedItem;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.dto.OrderableItemDetailsDTO;
import gr.mod.mil.stock.web.dto.UpdateOrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrderItemViewController {

    @Autowired
    LogService logger;

    @Autowired
    SecurityService security;

    @Autowired
    QuantityRepository repository;

    @Autowired
    Order order;

    @RequestMapping(value="/orderItem", method = RequestMethod.GET)
    public String view(
            Model model,
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam("title") String title,
            @RequestParam("category") String category,
            @RequestParam(value = "currentSupply", required = false) String currentSupply) {
        if(! security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        logger.log("visited the Orderable Item Details page for item: " + title);
        model.addAttribute("itemDetails", OrderableItemDetailsDTO.getDetailsFor(title, category, currentSupply));
        return "orderItem";
    }

    @RequestMapping(value="/orderItem", method= RequestMethod.POST)
    public String updateOrder(
            @AuthenticationPrincipal UserDetails userDetails,
            @ModelAttribute("updateOrderDto")UpdateOrderDTO data){
        if(! security.isAuthorizedAsAdmin(userDetails)){
            return "redirect:/?notAdmin=true";
        }
        order.appendItem(OrderedItem.getItemFrom(data.getTitle(), data.getCategory()), Integer.valueOf(data.getAmount()));
        logger.log("placed an order for the item: " + data.getTitle() + " of " + data.getAmount());
        return "redirect:order";
    }

}
