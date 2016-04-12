package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.DisplayDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class DisplayDeviceViewController {

    @Autowired
    DisplayDeviceRepository repository;

    @RequestMapping("/displayDevices")
    public String view(Model model, @RequestParam(value = "query", required = false) String query) {
        if (query != null && ! query.isEmpty()) {
            model.addAttribute("displays", repository.findByPublicid(query));
        }
        return "displayDevices";
    }
}
