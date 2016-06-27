package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.dal.repos.PrinterDeviceRepository;
import gr.mod.mil.stock.services.PrinterDeviceService;
import gr.mod.mil.stock.web.dto.printer.EditPrinterDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditPrinterDeviceViewController {

    @Autowired
    LogService logger;

    @Autowired
    PrinterDeviceRepository repository;

    @Autowired
    PrinterDeviceService service;

    @RequestMapping("/editPrinterDevice")
    public String view(Model model, @RequestParam("id") String id) {
        model.addAttribute("printer", repository.findByPublicid(id));
        logger.log("visited the edit Printer Device page");
        return "editPrinterDevice";
    }

    @RequestMapping(value = "/editPrinterDevice", method = RequestMethod.POST)
    public String edit(@ModelAttribute("editPrinterDeviceDto")EditPrinterDeviceDTO data){
        PrinterDevice edited  = service.edit(data);
        logger.log("edited a Printer Device with id: " + edited.getPublicid());
        return "redirect:/printerDevices?query=" + edited.getPublicid();
    }


}
