package gr.mod.mil.stock.web.controllers.computers;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.model.devices.builders.PersonalComputerBuilder;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.PersonalComputerService;
import gr.mod.mil.stock.web.dto.computer.AddPcDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddPersonalComputerViewController {

    @Autowired
    LogService logger;


    // import tin class PersonalComputerService
    @Autowired
    PersonalComputerService service;


    // i methodos gia to anoigma tis html selidas addPC
    @RequestMapping("/addPc")
    public String view(){
        return "addPc";
    }



    //I methodos gia tin prosthiki pc.
    // To Object data typou AddPcDTO epistrefetai apo tin html selida os model attribute

    @RequestMapping(value = "/addPc", method = RequestMethod.POST) // to value '/addPc' einai to onoma tou action tis form stin html selida addPcs
    public String addPc(@ModelAttribute("addPcDto")AddPcDTO data) { // Sto ModelAttribute("addPcDto") xrisimopoioume to name tis form pou vrisketai
                                                                    // sto addPc.html (<form role="form" method="post" action="addPc" name="addPcDto"> )
        PersonalComputer created = service.create(new PersonalComputerBuilder()
                .setModelName(data.getModelName().trim())
                .setSerialNum(data.getSerialNum().trim())
                .setPartNum(data.getPartNum().trim())
                .setPosition(data.getPosition())
                .setStatus(data.getStatus())
                .setRam(data.getRam())
                .setMemory(data.getMemory())
                .setCpu(data.getCpu())
                .setCpuSocket(data.getCpuSocket())
                .setDomain(data.getDomain())
                .setCaseType(data.getCaseType()));
        logger.log("added a personal computer with id: " + created.getPublicid());
        return "redirect:/addToBarcodePage?barcodeText="+created.getBarcodeText()+"&printableText="+created.getPrintableText();
    }
}
