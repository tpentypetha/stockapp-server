package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.printer.SearchPrinterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PrintersViewController {

    @Autowired
    PrinterRepository repo;

    @Autowired
    PrinterService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/printers", method = RequestMethod.GET)
    public String printers(@ModelAttribute("searchPrinterDto") SearchPrinterDTO data, Model model) {
        String query = data.getQuery() == null ? "" : data.getQuery().toLowerCase();
        model.addAttribute("printers", service.searchPrinters(query));
        logger.log("visited Printers page");
        return "printers";
    }

}
