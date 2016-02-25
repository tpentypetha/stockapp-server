package gr.mod.mil.stock.web;

import gr.mod.mil.stock.services.PrinterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPrinterViewController {

    private final static Logger log = LoggerFactory.getLogger(AddPrinterViewController.class);

    @Autowired
    PrinterService service;

    @RequestMapping(value = "addPrinter", method = RequestMethod.GET)
    public String addPrinter() {
        return "addPrinter";
    }

    @RequestMapping(value = "addPrinter", method = RequestMethod.POST)
    public String doAddPrinter(@ModelAttribute String name, ModelMap modelMap) {
        service.addPrinter(name);
        return "addPrinter";
    }

}
