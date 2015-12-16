package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.InkColor;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ConsumableService {

    @Autowired
    private ConsumableRepository consumables;

    private Logger log = LoggerFactory.getLogger(ConsumableService.class);

    public Consumable add(String code, InkColor color, int quantity, boolean critical) {
        Consumable newConsumable = create(code,color,quantity,critical);
        return consumables.save(newConsumable);
    }

    public Consumable edit(String publicid, String code, InkColor color, int quantity, boolean critical) {
        Consumable existing = consumables.findByPublicid(publicid);
        existing.setCode(code);
        existing.setColor(color);
        existing.setQuantity_available(quantity);
        existing.setCritical(critical);
        return consumables.save(existing);
    }

    public void markAsObsolete(String public_id) {
        Consumable consumable = consumables.findByPublicid(public_id);
        if (consumable != null) {
            consumable.setCritical(false);
            consumable.setQuantity_available(0);
            consumables.save(consumable);
        } else {
            ServiceErrors.failWith(ServiceErrors.CONSUMABLE_NOT_FOUND);
        }
    }

    public List<Consumable> searchByCode(String input) {
        return consumables.findByCode(input);
    }


    private Consumable create(String code, InkColor color, int quantity, boolean critical) {
        Consumable consumable = new Consumable();
        consumable.setCode(code);
        consumable.setColor(color);
        consumable.setCritical(critical);
        consumable.setQuantity_available(quantity);
        consumable.setPublicid(UUID.randomUUID().toString());
        return consumable;
    }

}
