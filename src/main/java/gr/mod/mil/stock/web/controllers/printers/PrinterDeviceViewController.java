package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.dal.repos.PrinterDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrinterDeviceViewController {

    @Autowired
    PrinterDeviceRepository repository;

    @RequestMapping("/printerDevices")
    public String view(Model model, @RequestParam(value = "query", required = false) String query) {
        if (query != null && ! query.isEmpty()) {
            model.addAttribute("printers", repository.findByPublicid(query));
        }
        return "printerDevices";
    }

}
