package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.services.LoginUserService;
import gr.mod.mil.stock.web.dto.RegisterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterViewController {

    Logger log = LoggerFactory.getLogger(RegisterViewController.class);

    @Autowired
    LoginUserService service;

    @RequestMapping("/register")
    public String viewPage(){
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleForm(@ModelAttribute("registerDto")RegisterDTO data){

        if (! data.isValid() ) {
            return "redirect:register?error";
        }

        try {
            service.createUser(data.getUsername(), data.getPassword());
        } catch (LoginUserService.UsernameAlreadyExists exc) {
            return "redirect:register?error";
        }

        return "redirect:login";
    }

}
