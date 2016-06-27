package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.web.dto.printer.AddPrinterDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPrinterViewController {

    private final static Logger log = LoggerFactory.getLogger(AddPrinterViewController.class);

    @Autowired
    PrinterService service;

    @Autowired
    LogService logger;

    @RequestMapping(value = "addPrinter", method = RequestMethod.GET)
    public String addPrinter() {
        logger.log("visited Add Printer page");
        return "addPrinter";
    }

    @RequestMapping(value = "addPrinter", method = RequestMethod.POST)
    public String doAddPrinter(@ModelAttribute("printerDto")AddPrinterDTO data) {
        service.addPrinter(data.getName());
        logger.log("added a printer with name: " + data.getName());
        return "redirect:printers";
    }

}
