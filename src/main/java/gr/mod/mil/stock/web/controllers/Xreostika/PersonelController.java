package gr.mod.mil.stock.web.controllers.Xreostika;


import gr.mod.mil.stock.dal.model.devices.*;
import gr.mod.mil.stock.dal.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class PersonelController {

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


    @RequestMapping(value = "/personel")
    public String view(Model model){

        List<Thl_Persons_Live> xristes=repository.getAll();
        List<Personel> personel= new ArrayList<Personel>();
        for(int i=0;i<xristes.size();i++){

            try {
                Personel person = new Personel();
                try {
                    person.setName(xristes.get(i).getG_name());
                } catch (Exception e) {
                    person.setName("");
                }
                try {
                    person.setSurname(xristes.get(i).getSurname());
                } catch (Exception e) {
                    person.setSurname("");
                }
                try {
                    String tmima = tmimata.findOne(xristes.get(i).getThl_tmhma_id()).getDescription();
                    person.setTmhma(tmima);
                }catch (Exception e){ person.setTmhma("");}

                try {
                    String rank = ranks.findOne(xristes.get(i).getRank_id()).getRank();
                    person.setRank(rank);
                }catch (Exception e){person.setRank("");}

                person.setId(xristes.get(i).getId());
                personel.add(person);
            }
            catch (Exception e){
                e.getMessage();
            }


        }

        model.addAttribute("personel", personel);


        return "personel";
    }


    @RequestMapping(value = "/editxreostika", method= RequestMethod.POST )
    public String view2(Model model,@ModelAttribute("id") String id
                        ){

        model.addAttribute("id",id);
        return "redirect:xreostika?id="+id;
    }



}
