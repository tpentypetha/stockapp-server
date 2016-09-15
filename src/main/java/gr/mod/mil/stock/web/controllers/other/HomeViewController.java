package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeViewController {

    @Autowired
    LogService logger;

    @RequestMapping("/")
    public String render(
            @RequestParam(value = "notAdmin", required = false) boolean notAdmin,
            @RequestParam(value = "newUser", required = false) boolean newUser,
            Model model){
        logger.log("visited Home page");
        model.addAttribute("notAdmin", notAdmin);
        model.addAttribute("newUser", newUser);
        return "home";
    }
}
