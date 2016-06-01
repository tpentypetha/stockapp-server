package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.services.TranferQuantity;
import gr.mod.mil.stock.web.dto.AddQuantityDTO;
import gr.mod.mil.stock.web.dto.TransferQuantityDTO;
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
public class TranferQuantityViewController {


    @Autowired
    CabinetRepository cabinetRepository;
    @Autowired
    ConsumableRepository consumableRepository;
    @Autowired
    TranferQuantity service;
    @Autowired
    LogService logger;

    @RequestMapping(value="/tranferQuantity",method = RequestMethod.GET)
    public String render(
            @RequestParam("cabinetid") String cabinetid,
            @RequestParam("consumableid") String consumableid,
            @RequestParam("quantityamount") String amount,
            @RequestParam("quantityid") String quantityid,
            Model model){
        model.addAttribute("cabinet", cabinetRepository.findByPublicid(cabinetid));
        model.addAttribute("consumable", consumableRepository.findByPublicid(consumableid));
        model.addAttribute("quantityamount", amount);
        model.addAttribute("cabinets", cabinetRepository.findAll());
        model.addAttribute("quantityid", quantityid);
        logger.log("visited tranferQuantity");

        return "transferQuantity";
    }


    @RequestMapping(value="/transferQ",method = RequestMethod.POST)
    public String render(
            @ModelAttribute("addQuantityDto")TransferQuantityDTO data,
            @RequestParam("cabinetid") String cabinetid,
            @RequestParam("consumableid") String consumableid,
            @RequestParam("quantity") String amount,
            @RequestParam("toCabinet") String tocabinetname,
            @RequestParam("totalamount") String totalamount,
            @RequestParam("quantityid") String quantityid,
            Model model){
        model.addAttribute("fromamont",data.getQuantity());
        model.addAttribute("toCabinet",data.getToCabinetid());
        model.addAttribute("cabinet", cabinetRepository.findByPublicid(cabinetid));
        model.addAttribute("consumable", consumableRepository.findByPublicid(consumableid));
        model.addAttribute("quantity", amount);
        model.addAttribute("totalamount", totalamount);
        model.addAttribute("toCabinet",cabinetRepository.getCabinetByname(tocabinetname) );
        logger.log("submited tranferQuantity");
        try{
            service.TranferQuantity(cabinetid,consumableid,totalamount,amount,tocabinetname,quantityid);
        }
        catch (Exception e){}
        return "redirect:cabinets";
    }
}



