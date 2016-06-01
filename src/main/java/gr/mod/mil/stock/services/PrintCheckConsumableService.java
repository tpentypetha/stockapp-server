package gr.mod.mil.stock.services;


import gr.mod.mil.stock.dal.model.print.PrintCheckConsumablePage;
import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrintCheckConsumableService {



    @Autowired
    private CabinetRepository cabinets;

    @Autowired
    private PrintCheckConsumablePage page;


    public void addToPrint(String cabinetid){

        Cabinet cabinet=cabinets.findByPublicid(cabinetid);
        page.addPrintable(cabinet);


    }

}
