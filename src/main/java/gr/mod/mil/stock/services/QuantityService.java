package gr.mod.mil.stock.services;


import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.Quantity;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuantityService {

    @Autowired
    private CabinetRepository cabinets;

    @Autowired
    private QuantityRepository quantities;

    @Autowired
    private ConsumableRepository consumables;

    public Quantity getQuantity(String quantityid){
        return quantities.findByPublicid(quantityid);
    }

    public Quantity addQuantity(String cabinetid, String consumableid, int initialAmount) {
        Cabinet cabinet = cabinets.findByPublicid(cabinetid);
        Consumable consumable = consumables.findByPublicid(consumableid);

        Quantity quantity = new Quantity();
        quantity.setConsumable(consumable);
        quantity.setAmount(initialAmount);
        quantity.setPublicid(UUID.randomUUID().toString());
        Quantity saved = quantities.save(quantity);

        cabinet.getQuantities().add(saved);
        cabinets.save(cabinet);
        return saved;
    }

    public Quantity setEmptyQuantity(String quantityid) {
        Quantity quantity = quantities.findByPublicid(quantityid);
        quantity.setEmpty();
        return quantities.save(quantity);
    }

    public Quantity submitCount(String quantityid, int amount){
        Quantity quantity = quantities.findByPublicid(quantityid);
        quantity.setAmount(amount);
        return quantities.save(quantity);
    }

}
