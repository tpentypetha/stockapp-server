package gr.mod.mil.stock.web.controllers.printers;

import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.dal.model.devices.builders.PrinterDeviceBuilder;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PrinterDeviceService;
import gr.mod.mil.stock.web.dto.printer.PrinterDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPrinterDeviceViewController {


    @Autowired
    LogService logger;

    @Autowired
    PrinterDeviceService service;

    @RequestMapping("/addPrinterDevice")
    public String view(){
        return "addPrinterDevice";
    }

    @RequestMapping(value = "/addPrinterDevice", method = RequestMethod.POST)
    public String addPrinterDevice(@ModelAttribute("addPrinterDeviceDto")PrinterDeviceDTO data) {
        PrinterDevice created = service.create(new PrinterDeviceBuilder()
                .setModelName(data.getModelName().trim())
                .setSerialNum(data.getSerialNum().trim())
                .setPartNum(data.getPartNum().trim())
                .setPosition(data.getPosition())
                .setStatus(data.getStatus())
                .setTechnology(data.getTechnology())
                .setNetworkPrinter(data.getNetworkPrinter())
                .setColorPrinter(data.getColorPrinter())
                .setMultiPurposeMachine(data.getMultiPurposeMachine()));
        logger.log("added a printer device with id: " + created.getPublicid());
        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();
    }
}