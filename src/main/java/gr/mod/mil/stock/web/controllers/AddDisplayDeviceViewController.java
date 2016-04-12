package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.devices.Display;
import gr.mod.mil.stock.dal.model.devices.builders.DisplayDeviceBuilder;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.DisplayDeviceService;
import gr.mod.mil.stock.web.dto.DisplayDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddDisplayDeviceViewController {

    @Autowired
    LogService logger;

    @Autowired
    DisplayDeviceService service;

    @RequestMapping("/addDisplayDevice")
    public String view(){
        return "addDisplayDevice";
    }


    @RequestMapping(value = "/addDisplayDevice", method = RequestMethod.POST)

    public String addDisplayDevice(@ModelAttribute("addDisplayDeviceDto")DisplayDeviceDTO data) {
        Display created = service.create(new DisplayDeviceBuilder()
                .setModelName(data.getModelName().trim())
                .setSerialNum(data.getSerialNum().trim())
                .setPartNum(data.getPartNum().trim())
                .setPosition(data.getPosition())
                .setStatus(data.getStatus())
                .setInches(data.getInches())
                .setVga(data.getVga())
                .setDvi(data.getDvi())
                .setHdmi(data.getHdmi()));
        logger.log("added a display device with id: " + created.getPublicid());
        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();
    }

}
