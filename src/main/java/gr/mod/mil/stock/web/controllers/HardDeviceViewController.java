package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.repos.HardDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HardDeviceViewController {

    @Autowired
    HardDeviceRepository repository;

    @RequestMapping("/hardDevices")
    public String view(Model model, @RequestParam(value = "query", required = false) String query) {
        if (query != null && ! query.isEmpty()) {
            model.addAttribute("hdds", repository.findByPublicid(query));
        }
        return "hardDevices";
    }

}
