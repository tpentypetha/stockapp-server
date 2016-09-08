package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.web.dto.quantity.EditQuantityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RemoveQuantityFromCabinet {

    @Autowired
    QuantityService service;
    @Autowired
    CabinetRepository repository;
    @Autowired
    LogService logger;

    @RequestMapping("/removeConsumableFromCabinet")
    public String viewPage(@RequestParam("cabinetid") String cabinetid,@RequestParam("quantityid") String quantityid,
                           Model model){
        model.addAttribute("cabinet", repository.findByPublicid(cabinetid));
        model.addAttribute("quantity", service.getQuantity(quantityid));
        logger.log("visited the Remove Cabinet page");
        return "removeConsumableFromCabinet";
    }

    @RequestMapping(value = "/RemoveQuantityFromCabinet", method = RequestMethod.POST)
    public String processIncrease(@ModelAttribute("EditQuantityDTO") EditQuantityDTO data){

        service.RemoveQuantity(data.getQuantityid());
        logger.log("removed consumable from cabinet with public id: " + data.getQuantityid() );
        return "redirect:cabinet?id="+data.getCabinetid();
    }
    //(cabinetid=${cabinet.publicid},quantityid=${quantity.publicid})}
    /*<form role="form" name="editQuantityDto" action="/RemoveQuantityFromCabinet" method="post">
    <input type="hidden" th:name="${_csrf.parameterName}" th:value="${_csrf.token}"></input>
    <input type="hidden" name="cabinetid" th:value="${cabinet.publicid}"></input>
    <input type="hidden" name="quantityid" th:value="${quantity.publicid}"></input>
    <button type="sumbit" class="btn btn-danger">Διαγραφή</button>
    </form>*/
}
