package gr.mod.mil.stock.webservices.controllers;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.services.ConsumableService;
import gr.mod.mil.stock.webservices.dto.ConsumableRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ConsumablesController {

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
        return service.add(request.getCode(), request.getColor(), request.getQuantity(), request.getCritical());
    }

    @RequestMapping(value="/api/consumables/{consumableid}", method=RequestMethod.PUT)
    public Consumable editConsumable(@PathVariable("consumableid") String consumableid, @RequestBody ConsumableRequestDTO request) {
        return service.edit(consumableid, request.getCode(), request.getColor(), request.getQuantity(), request.getCritical());
    }

    @RequestMapping(value = "/api/consumables/{consumableid}", method = RequestMethod.DELETE)
    public void markAsObsolete(@PathVariable("consumableid") String consumableid) {
        service.markAsObsolete(consumableid);
    }

}
