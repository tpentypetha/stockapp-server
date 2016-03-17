package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.web.dto.EditQuantityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EditQuantityAmountController {

    @Autowired
    QuantityService service;

    @RequestMapping(value = "/editQuantity", method = RequestMethod.POST)
    public String processIncrease(@ModelAttribute("editQuantityDto") EditQuantityDTO data){
        service.submitCount(data.getQuantityid(), data.getAmount());
        return "redirect:cabinet?id="+data.getCabinetid();
    }

}