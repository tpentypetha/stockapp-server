package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CabinetService {

    @Autowired
    private CabinetRepository cabinets;

    public Cabinet addCabinet(String name) {
        List<Cabinet> found = cabinets.CabinetAllreadyExists(name);
        if (!found.isEmpty()) {
            throw new CabinetAlreadyExists(found.get(0));
        }
        Cabinet cabinet = new Cabinet();
        cabinet.setName(name);
        cabinet.setPublicid(UUID.randomUUID().toString());
        return cabinets.save(cabinet);

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

    public class CabinetAlreadyExists extends RuntimeException {

        private final Cabinet cabinet;
        public Cabinet getCabinet() { return cabinet; }

        public CabinetAlreadyExists(Cabinet cabinet) {
            super(cabinet.getName()+" already exists");
            this.cabinet = cabinet;
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
