package gr.mod.mil.stock.web.controllers.services;


import gr.mod.mil.stock.dal.model.stock.Contacts;
import gr.mod.mil.stock.dal.model.stock.Tickets;
import gr.mod.mil.stock.dal.repos.ContactsRepository;
import gr.mod.mil.stock.dal.repos.TicketingRepository;
import gr.mod.mil.stock.web.dto.TicketingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.security.krb5.internal.Ticket;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class AddTicketService {

    @Autowired
    TicketingRepository repo;
    @Autowired
    ContactsRepository contactsrepo;

    public void Submit(TicketingDTO data){

        Tickets newTicket =new Tickets();
        newTicket.setPhone(data.getPhone());
        newTicket.setName(data.getName());
        newTicket.setOffice(data.getOffice());
        newTicket.setNotes(data.getNotes());
        newTicket.setProblem(data.getProblem());
        newTicket.setStatus("Σε αναμονή");
        newTicket.setDatein(new Date());
        repo.save(newTicket);

        Contacts contact= new Contacts();
        contact.setPhone(data.getPhone());
        contact.setOffice(data.getOffice());
        contact.setName(data.getName());

        if(contact.getName()==null)contact.setName("");
            if(contact.getOffice()==null) contact.setOffice("");



        Contacts oldcontact= contactsrepo.findbyId(data.getPhone());

        if(oldcontact!=null) {
            if(oldcontact.getName()==null)oldcontact.setName("");
            if(oldcontact.getOffice()==null) oldcontact.setOffice("");
            if (!oldcontact.getOffice().equals(contact.getOffice()) || !oldcontact.getName().equals(contact.getName())) {
                contactsrepo.delete(oldcontact);
                contactsrepo.save(contact);
            }
        }

        else{
            contactsrepo.save(contact);
        }

    }

    public void SetSolved(Long id,String user) {



        Tickets t=repo.findbyId(id);
        t.setStatus("Επιλύθηκε");

        t.setDatein(new Date());
        t.setUser(user);
        repo.save(t);




    }


    public Contacts getContact(String phone) {


        Contacts con=contactsrepo.findbyId(phone);


        return con;



    }


    public void saveEdit(String id, String notes) {


        Tickets t=repo.findbyId(Long.valueOf(id));
        t.setNotes(notes);
        repo.save(t);


    }
}
