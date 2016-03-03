package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.AddPrinterConsumableDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AddPrinterConsumableViewController {

    @Autowired
    PrinterRepository printerRepo;

    @Autowired
    ConsumableRepository consumableRepo;

    @Autowired
    PrinterService printerService;

    @RequestMapping(value="/addPrinterConsumable", method= RequestMethod.GET)
    public String render(@RequestParam("printer")String printer, @RequestParam(value="code", required = false) String code, Model model){
        model.addAttribute("printer", printerRepo.findByPublicid(printer));
        model.addAttribute("consumables", getConsumablesForCode(code));
        return "addPrinterConsumable";
    }

    @RequestMapping(value = "/addPrinterConsumable", method = RequestMethod.POST)
    public String add(@ModelAttribute("addPrinterConsumableDto")AddPrinterConsumableDTO data){
        printerService.assignConsumable(data.getPrinterid(), data.getConsumableid());
        return "redirect:printer?id="+data.getPrinterid();
    }

    private List<Consumable> getConsumablesForCode(String code) {
        if (code == null || code.trim().equals("")) {
            return new ArrayList<>();
        } else {
            return consumableRepo.findByCode(code.toLowerCase());
        }
    }

}
