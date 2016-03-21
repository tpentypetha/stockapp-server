package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.SecurityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginUsersViewController {

    Logger log = LoggerFactory.getLogger(LoginUsersViewController.class);

    @Autowired
    SecurityService security;

    @RequestMapping("/loginusers")
    public String render(@AuthenticationPrincipal UserDetails user){
        if (! security.isAuthorizedAsAdmin(user)){
            return "redirect:/?notAdmin=true";
        }
        return "loginusers";
    }

}
