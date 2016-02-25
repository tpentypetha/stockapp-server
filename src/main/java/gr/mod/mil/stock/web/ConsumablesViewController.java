package gr.mod.mil.stock.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ConsumablesViewController {

    @RequestMapping(value = "/consumables", method = RequestMethod.GET)
    public String consumables() {
        return "consumables";
    }
}
