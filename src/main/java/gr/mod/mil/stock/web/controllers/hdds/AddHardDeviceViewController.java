package gr.mod.mil.stock.web.controllers.hdds;


import gr.mod.mil.stock.dal.model.devices.HardDrive;
import gr.mod.mil.stock.dal.model.devices.builders.HardDeviceBuilder;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.HardDeviceService;
import gr.mod.mil.stock.web.dto.HardDeviceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class AddHardDeviceViewController {

    @Autowired
    LogService logger;

    @Autowired
    HardDeviceService service;

    @RequestMapping("/addHardDevice")
    public String view(){
        return "addHardDevice";
    }

    @RequestMapping(value = "/addHardDevice", method = RequestMethod.POST)
    public String addHardDrive(@ModelAttribute("addHardDeviceDto")HardDeviceDTO data) {
        HardDrive created = service.create(new HardDeviceBuilder()
                .setModelName(data.getModelName().trim())
                .setSerialNum(data.getSerialNum().trim())
                .setPartNum(data.getPartNum().trim())
                .setPosition(data.getPosition())
                .setStatus(data.getStatus())
                .setCapacity(data.getCapacity())
                .setTechnology(data.getTechnology())
                .setSocket(data.getSocket()));
        logger.log("added a hard device with id: " + created.getPublicid());
        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();
    }


}
