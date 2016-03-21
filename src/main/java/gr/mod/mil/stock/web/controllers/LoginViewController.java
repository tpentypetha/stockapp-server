package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginViewController {

    @Autowired
    LogService logger;

    @RequestMapping("/login")
    public String viewLogin() {
        logger.log("visited login page");
        return "login";
    }
}
