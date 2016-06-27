package gr.mod.mil.stock.web.controllers.cabinets;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.CabinetService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.web.dto.cabinet.RemoveCabinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveCabinetViewController {

    @Autowired
    CabinetRepository repository;

    @Autowired
    CabinetService service;

    @Autowired
    LogService logger;

    @RequestMapping("/removeCabinet")
    public String viewPage(@RequestParam("id") String id, Model model){
        model.addAttribute("cabinet", repository.findByPublicid(id));
        logger.log("visited the Remove Cabinet page");
        return "removeCabinet";
    }

    @RequestMapping(value = "/removeCabinet", method = RequestMethod.POST)
    public String doRemove(@ModelAttribute("removeCabinetDto")RemoveCabinetDTO data,
                           @RequestParam("cabinetid") String cabinetid,
                           @RequestParam(value = "error", required = false) boolean error,
                           Model model) {
        Cabinet cabinet = repository.findByPublicid(data.getCabinetid());
        model.addAttribute("error", error);
        if(cabinet.getQuantities().size()>0){
            model.addAttribute("cabinet", repository.findByPublicid(cabinetid));
            return "redirect:cabinet?id="+cabinetid+"&error=true";
        }
        else{
            service.removeCabinet(data.getCabinetid());
            logger.log("removed the cabinet: " + cabinet.getName());
            return "redirect:cabinets";
        }



    }

}
