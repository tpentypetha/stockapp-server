package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.Quantity;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CabinetService {

    @Autowired
    private CabinetRepository cabinets;

    public Cabinet addCabinet(String name) {
        List<Cabinet> found = cabinets.findByName(name);
        if (found.isEmpty()) {
            Cabinet cabinet = new Cabinet();
            cabinet.setName(name);
            cabinet.setPublicid(UUID.randomUUID().toString());
            return cabinets.save(cabinet);
        } else {
            ServiceErrors.failWith(ServiceErrors.CABINET_ALREADY_EXISTS);
            return null;
        }
    }

    public void editCabinet(String publicid, String name) {
        Cabinet found = cabinets.findByPublicid(publicid);
        if (found != null) {
            found.setName(name);
            cabinets.save(found);
        } else {
            ServiceErrors.failWith(ServiceErrors.CABINET_NOT_FOUND);
        }
    }

    public void removeCabinet(String publicid) {
        Cabinet found = cabinets.findByPublicid(publicid);
        if (found == null) {
            ServiceErrors.failWith(ServiceErrors.CABINET_NOT_FOUND);
        } else {
            cabinets.delete(found);
        }
    }

    public List<Cabinet> searchByName(String input) {
        return cabinets.findByName(input);
    }

}
