package gr.mod.mil.stock.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeViewController {

    @RequestMapping("/")
    public String render(){
        return "home";
    }
}
