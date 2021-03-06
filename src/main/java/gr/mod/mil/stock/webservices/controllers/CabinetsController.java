package gr.mod.mil.stock.webservices.controllers;

import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.services.CabinetService;
import gr.mod.mil.stock.webservices.dto.CabinetRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CabinetsController {

    @Autowired
    CabinetRepository cabinets;

    @Autowired
    CabinetService service;

    @RequestMapping(value="/api/cabinets",method = RequestMethod.POST)
    public void addCabinet(@RequestBody CabinetRequestDTO request) {
        service.addCabinet(request.getName());
    }

    @RequestMapping(value = "/api/cabinets/{publicid}")
    public Cabinet getCabinetByPublicId(@PathVariable("publicid") String publicid){
        return cabinets.findByPublicid(publicid);
    }

    @RequestMapping(value = "/api/cabinets")
    public List<Cabinet> searchByName(@RequestParam("name") String name) {
        return service.searchByName(name);
    }

    @RequestMapping(value = "/api/cabinets/{publicid}", method = RequestMethod.PUT)
    public void editCabinet(@PathVariable("publicid") String publicid, @RequestBody CabinetRequestDTO request) {
        service.editCabinet(publicid, request.getName());
    }

    @RequestMapping(value = "/api/cabinets/{publicid}", method = RequestMethod.DELETE)
    public void deleteCabinet(@PathVariable("publicid") String publicid) {
        service.removeCabinet(publicid);
    }

}
