package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.CabinetService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.web.dto.AddCabinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddCabinetViewController {

    @Autowired
    CabinetService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/addCabinet", method = RequestMethod.GET)
    public String addCabinet(){
        logger.log("visited Add Cabinet page");
        return "addCabinet";
    }

    @RequestMapping(value = "/addCabinet", method = RequestMethod.POST)
    public String processPost(@ModelAttribute("addCabinetDto") AddCabinetDTO data) {
        String name = data.getName() != null ? data.getName() : "";
        service.addCabinet(name);
        logger.log("added a new cabinet with name: " + data.getName());
        return "redirect:cabinets";
    }
}
