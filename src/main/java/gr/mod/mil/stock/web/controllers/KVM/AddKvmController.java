package gr.mod.mil.stock.web.controllers.KVM;

import gr.mod.mil.stock.dal.model.devices.KeyboardVideoMouse;
import gr.mod.mil.stock.services.AddKvmService;
import gr.mod.mil.stock.web.dto.kvm.addKvmDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddKvmController  {

    @Autowired
    AddKvmService service;

    @RequestMapping("/addKvm")
    public String view(Model model) {

        return "addKvm";
    }


    @RequestMapping(value="/addKvmDevice", method = RequestMethod.POST)
    public String addkvm(Model model,@ModelAttribute("KvmDeviceDto")addKvmDeviceDto data) {

        KeyboardVideoMouse created=service.addKvm(data);

        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();

    }




}
