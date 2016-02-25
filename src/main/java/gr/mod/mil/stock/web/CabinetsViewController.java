package gr.mod.mil.stock.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CabinetsViewController {

    @RequestMapping(value = "/cabinets", method = RequestMethod.GET)
    public String index(Model model) {
        return "cabinets";
    }

}
