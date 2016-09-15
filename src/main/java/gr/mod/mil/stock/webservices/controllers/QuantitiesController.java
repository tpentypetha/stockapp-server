package gr.mod.mil.stock.webservices.controllers;

import gr.mod.mil.stock.dal.model.stock.Quantity;
import gr.mod.mil.stock.services.QuantityService;
import gr.mod.mil.stock.webservices.dto.AddQuantityRequestDTO;
import gr.mod.mil.stock.webservices.dto.CountRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuantitiesController {

    @Autowired
    QuantityService service;

    @RequestMapping(value="/api/quantities", method = RequestMethod.POST)
    public Quantity addQuantity(@RequestBody AddQuantityRequestDTO data){
        return service.addQuantity(data.getCabinetid(), data.getConsumableid(), data.getAmount());
    }

    @RequestMapping(value="/api/quantities/{quantityid}", method = RequestMethod.GET)
    public Quantity getQuantity(@PathVariable("quantityid") String quantityid){
        return service.getQuantity(quantityid);
    }

    @RequestMapping(value = "/api/quantities/{quantityid}", method = RequestMethod.PUT)
    public Quantity submitCount(@PathVariable("quantityid") String quantityid, @RequestBody CountRequestDTO data){
        return service.submitCount(quantityid, data.getAmount(),"ΤΜΗΜΑ ΠΛΗΡΟΦΟΡΙΚΗΣ - ΕΠΙΚΟΙΝΩΝΙΩΝ - ΝΕΩΝ ΤΕΧΝΟΛΟΓΙΩΝ");
    }

    @RequestMapping(value = "/api/quantities/{quantityid}", method = RequestMethod.DELETE)
    public Quantity setEmpty(@PathVariable("quantityid") String quantityid) {
        return service.setEmptyQuantity(quantityid);
    }

}
