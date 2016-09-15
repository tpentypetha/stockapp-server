package gr.mod.mil.stock.web.controllers.peripherals;

import gr.mod.mil.stock.dal.model.devices.Peripheral;
import gr.mod.mil.stock.dal.repos.KvmRepository;
import gr.mod.mil.stock.dal.repos.PeripheralRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.web.dto.peripheral.PeripheralDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class PeripheralController
{
    @Autowired
    LogService logger;

    @Autowired
    PeripheralRepository repository;


    @RequestMapping(value = "/peripherals")
    public String view(Model model){


        String s=UUID.randomUUID().toString().trim();
        System.out.println(s);
        model.addAttribute("peripherals", repository.findAll());


        return "peripherals";
    }

    @RequestMapping(value="/peripheralToBarcodePage", method=RequestMethod.POST)
    public String view(Model model,  @ModelAttribute("publicid") String publicid
                       )
    {
        Peripheral created = repository.findByPublicid(publicid);


        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();
    }
}
