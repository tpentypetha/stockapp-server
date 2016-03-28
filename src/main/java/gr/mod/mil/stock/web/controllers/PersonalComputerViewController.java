package gr.mod.mil.stock.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonalComputerViewController {

    @RequestMapping("/pcs")
    public String view(){
        return "pcs";
    }

}
