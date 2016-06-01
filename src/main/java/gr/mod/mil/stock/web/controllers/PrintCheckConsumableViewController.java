package gr.mod.mil.stock.web.controllers;


import gr.mod.mil.stock.dal.model.print.PrintCheckConsumablePage;
import gr.mod.mil.stock.dal.repos.CabinetRepository;

import gr.mod.mil.stock.services.PrintCheckConsumableService;
import gr.mod.mil.stock.web.dto.PrintCabinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrintCheckConsumableViewController {

    @Autowired
    PrintCheckConsumablePage page;

    @Autowired
    CabinetRepository repo;

    @Autowired
    PrintCheckConsumableService service;

    @RequestMapping("/printCheckConsumable")
    public String getView(
            Model model) {
        model.addAttribute("cabinets", page.getPrintables());

        return "printCheckConsumable";
    }


    @RequestMapping(value = "/addToPrintCheckConsumable", method = RequestMethod.POST)
    public String processPost(@ModelAttribute("printCabinetDTO") PrintCabinetDTO data,
                              Model model) {


        model.addAttribute(data.getCabinetid());

        service.addToPrint(data.getCabinetid());
        return "redirect:cabinet?id="+data.getCabinetid();

    }




}
