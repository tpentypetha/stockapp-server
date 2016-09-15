package gr.mod.mil.stock.web.controllers.other;


import gr.mod.mil.stock.dal.model.stock.Contacts;
import gr.mod.mil.stock.dal.model.stock.Tickets;
import gr.mod.mil.stock.dal.model.system.TicketFormat;
import gr.mod.mil.stock.dal.repos.LoginUserRepository;
import gr.mod.mil.stock.dal.repos.TicketingRepository;
import gr.mod.mil.stock.web.controllers.services.AddTicketService;
import gr.mod.mil.stock.web.dto.TicketingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;


@Controller
public class Ticketing {

    @Autowired
    AddTicketService service;

    @Autowired
    LoginUserRepository usersRepo;

    @Autowired
    TicketingRepository repo;

    @RequestMapping(value="/ticketing",  method = RequestMethod.GET)
    public String getView(
            Model model) {


        List<String> a=usersRepo.getAllUsers();

        List<TicketFormat> tickets =new ArrayList<TicketFormat>();
        List<Tickets> oldtickets= repo.getPending();

        for(int i=0;i<oldtickets.size();i++){
            TicketFormat as=new TicketFormat();
            as.setId(oldtickets.get(i).getId());
            as.setPhone(oldtickets.get(i).getPhone());
            as.setStatus(oldtickets.get(i).getStatus());
            as.setName(oldtickets.get(i).getName());
            as.setNotes(oldtickets.get(i).getNotes());
            as.setOffice(oldtickets.get(i).getOffice());
            as.setProblem(oldtickets.get(i).getProblem());
            String d= DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(oldtickets.get(i).getDatein());
            as.setDatein(d);
            tickets.add(as);
        }



        model.addAttribute("pending_tickets",tickets);
        model.addAttribute("users",usersRepo.getAllUsers());

        return "ticketing";
    }

    @RequestMapping(value="/addticket", method = RequestMethod.POST)
    public String post_ticket(
            @ModelAttribute("ticketingDTO") TicketingDTO data,
            Model model) {

        service.Submit(data);


        String s="";

        return "redirect:ticketing";
    }


    @RequestMapping(value="/setticketSolved", method = RequestMethod.POST)
    public String set_ticketSolved(
            @ModelAttribute("ticketid") String id,
            @ModelAttribute("user") String user,
            Model model) {


        service.SetSolved(Long.valueOf(id),user);



        return "redirect:ticketing";
    }

    @RequestMapping("/autofillticket/{phone}")
    public @ResponseBody Contacts set_autofillticket(@PathVariable String phone) {


        String s="fsdfsd";
        System.out.println("autofillticket method  " +phone );


        return service.getContact(phone);
    }


    @RequestMapping("/editticket/{id}/{notes}")
    public   String edit_ticket(@PathVariable String id,@PathVariable String notes) {


        //service.Submit(data);

        service.saveEdit(id,notes);


        return null;
    }


    @RequestMapping("/get10solved")
    public @ResponseBody List<TicketFormat> get_ticketSolved(
            ) {


       String s="";
        List<TicketFormat> tickets =new ArrayList<TicketFormat>();
        List<Tickets> oldtickets= repo.getlast10Solved();

        for(int i=0;i<oldtickets.size();i++){

            TicketFormat as=new TicketFormat();
            as.setId(oldtickets.get(i).getId());
            as.setPhone(oldtickets.get(i).getPhone());
            as.setStatus(oldtickets.get(i).getStatus());
            as.setName(oldtickets.get(i).getName());
            as.setNotes(oldtickets.get(i).getNotes());
            as.setOffice(oldtickets.get(i).getOffice());
            as.setProblem(oldtickets.get(i).getProblem());
            String d= DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT).format(oldtickets.get(i).getDatein());
            as.setDatein(d);
            tickets.add(as);
        }
        return tickets;
    }

    @RequestMapping(value="/10solvedtickets",  method = RequestMethod.POST)
    public String getView2(
            Model model) {

        return "10solvedtickets";
    }
}
