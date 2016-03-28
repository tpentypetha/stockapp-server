package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.InkColor;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.webservices.dto.AvailabilityDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ConsumableService {

    @Autowired
    private ConsumableRepository consumables;

    private Logger log = LoggerFactory.getLogger(ConsumableService.class);

    public Consumable add(String code, InkColor color, boolean critical) {
        Consumable newConsumable = create(code,color,critical);
        return consumables.save(newConsumable);
    }

    public Consumable edit(String publicid, String code, InkColor color, boolean critical) {
        Consumable existing = consumables.findByPublicid(publicid);
        existing.setCode(code);
        existing.setColor(color);
        existing.setCritical(critical);
        return consumables.save(existing);
    }

    public void markAsObsolete(String public_id) {
        Consumable consumable = consumables.findByPublicid(public_id);
        if (consumable != null) {
            consumable.setCritical(false);
            consumables.save(consumable);
        } else {
            ServiceErrors.failWith(ServiceErrors.CONSUMABLE_NOT_FOUND);
        }
    }

    public List<Consumable> searchByCode(String input) {
        return consumables.findByCode(input);
    }

    public List<AvailabilityDTO> getAvailable(String publicid) {
        Consumable consumable = consumables.findByPublicid(publicid);
        List<Cabinet> cabinets = consumables.getAvailability(consumable.getCode());
        List<AvailabilityDTO> availabilityDTOs = new ArrayList<>();
        cabinets.stream().forEach(cabinet -> {
            cabinet.getQuantities().stream().forEach(quantity -> {
                if (quantity.getConsumable().getPublicid().equals(publicid)) {
                    AvailabilityDTO dto = new AvailabilityDTO();
                    dto.setAmount(quantity.getAmount());
                    dto.setCabinetId(cabinet.getPublicid());
                    dto.setCabinetName(cabinet.getName());
                    availabilityDTOs.add(dto);
                }
            });
        });
        return availabilityDTOs;
    }


    private Consumable create(String code, InkColor color, boolean critical) {
        Consumable consumable = new Consumable();
        consumable.setCode(code);
        consumable.setColor(color);
        consumable.setCritical(critical);
        consumable.setPublicid(UUID.randomUUID().toString());
        return consumable;
    }

}
