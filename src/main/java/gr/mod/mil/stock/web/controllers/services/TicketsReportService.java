package gr.mod.mil.stock.web.controllers.services;

import gr.mod.mil.stock.dal.model.stock.Tickets;
import gr.mod.mil.stock.dal.repos.TicketingRepository;
import gr.mod.mil.stock.web.dto.TicketingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class TicketsReportService {

    @Autowired
    TicketingRepository repo;


    public List<Tickets> getReport(Date from, Date to, String officetxt, String phonetxt) {

        List<Tickets> tickets= new ArrayList<Tickets>();


        if(officetxt!="" && phonetxt!="")
            tickets=repo.getTicketsReport(from,to,officetxt,phonetxt);
        else if(officetxt=="" && phonetxt=="")
            tickets=repo.getTicketsReportwithoutall(from,to);
        else if(officetxt=="")
            tickets=repo.getTicketsReportwithoutoffice(from,to,phonetxt);
        else if(phonetxt=="")
             tickets=repo.getTicketsReportwithoutphone(from,to,officetxt)   ;

        return tickets;


    }


}
