package gr.mod.mil.stock.web.controllers.Xreostika;

import gr.mod.mil.stock.dal.model.devices.*;
import gr.mod.mil.stock.dal.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class XreostikaController {


    @Autowired
    Thl_PersonsRepository repository;

    @Autowired
    RanksRepository ranks;

    @Autowired
    Thl_TmhmaRepository tmimata;
    @Autowired
    PersonalComputerRepository pcs_repo;

    @Autowired
    DisplayDeviceRepository othones_repo;

    @Autowired
    PrinterDeviceRepository printers_repo;

    @Autowired
    PeripheralRepository peripherals_repo;

    @Autowired
    KvmRepository kvms_repo;



    @RequestMapping(value = "/xreostika", method= RequestMethod.GET )
    public String view2(Model model, @RequestParam("id") String id

    ){

        model.addAttribute("id",id);

        Thl_Persons user=repository.getbyid(Long.valueOf(id));

        model.addAttribute("rank",ranks.findOne(user.getRank_id()).getRank());
        model.addAttribute("surname",user.getSurname());
        model.addAttribute("name",user.getG_name());



        List<PersonalComputer> pcs= pcs_repo.getComputers_thatBelongsTo(Long.valueOf(id));
        model.addAttribute("pcs",pcs);

        List<Display> othones = othones_repo.getDisplays_thatBelongsTo(Long.valueOf(id));
        model.addAttribute("displays",othones);

        List<PrinterDevice> printers=printers_repo.getPrinter_thatBelongsTo(Long.valueOf(id));
        model.addAttribute("printers",printers);

        List<KeyboardVideoMouse> kvms= kvms_repo.getKvms_ThatBelongsTo(Long.valueOf(id));
        model.addAttribute("kvms",kvms);

        List<Peripheral> peripherals=peripherals_repo.getPeripheralsThat_BelongsTo(Long.valueOf(id));
        model.addAttribute("peripherals",peripherals);

        return "xreostika";
    }




    @RequestMapping(value = "/removepcfromuser", method= RequestMethod.POST )
    public String view4(Model model, @ModelAttribute("id") String id,
                        @ModelAttribute("pcid") String pcid

    ) {


        PersonalComputer pc= pcs_repo.findByPublicid(pcid);
        pc.setBelongs_to(0);
        pcs_repo.save(pc);




        return "redirect:xreostika?id="+id;
    }


   




}
