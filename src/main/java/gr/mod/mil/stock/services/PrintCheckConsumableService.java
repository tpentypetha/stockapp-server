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
    public CabinetRepository getCabinets() {return cabinets;}

    @Autowired
    private PrintCheckConsumablePage page;


    public void addToPrint(String cabinetID){
        Cabinet cabinet=cabinets.findByPublicid(cabinetID);
        page.addPrintable(cabinet);
    }

    public boolean isAdded(String cabinetID){
        Cabinet cabinet=cabinets.findByPublicid(cabinetID);
        return page.getPrintables().contains(cabinet);
    }

}
