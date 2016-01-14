package gr.mod.mil.stock.webservices.controllers;

import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.webservices.dto.AvailabilityDTO;
import gr.mod.mil.stock.webservices.dto.ConsumableRequestDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ConsumablesController {

    public final static Logger log = LoggerFactory.getLogger(ConsumablesController.class);

    @Autowired
    ConsumableRepository consumables;

    @Autowired
    ConsumableService service;

    @RequestMapping(value="/api/consumables")
    public List<Consumable> searchByCode(@RequestParam String code) {
        return service.searchByCode(code);
    }

    @RequestMapping(value="/api/consumables/{publicid}")
    public Consumable getByPublicid(@PathVariable String publicid) {
        return consumables.findByPublicid(publicid);
    }

    @RequestMapping(value = "/api/consumables", method= RequestMethod.POST)
    public Consumable addConsumable(@RequestBody  ConsumableRequestDTO request) {
        return service.add(request.getCode(), request.getColor(), request.getCritical());
    }

    @RequestMapping(value="/api/consumables/{consumableid}", method=RequestMethod.PUT)
    public Consumable editConsumable(@PathVariable("consumableid") String consumableid, @RequestBody ConsumableRequestDTO request) {
        return service.edit(consumableid, request.getCode(), request.getColor(), request.getCritical());
    }

    @RequestMapping(value = "/api/consumables/{consumableid}", method = RequestMethod.DELETE)
    public void markAsObsolete(@PathVariable("consumableid") String consumableid) {
        service.markAsObsolete(consumableid);
    }

    @RequestMapping(value = "api/consumables/{consumableid}/availability")
    public List<AvailabilityDTO> getAvailabilty(@PathVariable("consumableid") String consumableid) {
        Consumable consumable = consumables.findByPublicid(consumableid);
        List<Cabinet> cabinets = consumables.getAvailability(consumable.getCode());
        List<AvailabilityDTO> availabilityDTOs = new ArrayList<>();
        cabinets.stream().forEach(cabinet -> {
            log.info("Cabinet: " + cabinet.getName());
            cabinet.getQuantities().stream().forEach(quantity -> {
                if (quantity.getConsumable().getPublicid().equals(consumableid)) {
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

}
