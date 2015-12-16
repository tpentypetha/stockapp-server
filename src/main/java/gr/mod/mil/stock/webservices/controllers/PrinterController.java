package gr.mod.mil.stock.webservices.controllers;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.Printer;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import gr.mod.mil.stock.services.PrinterService;
import gr.mod.mil.stock.webservices.dto.AddConsumableRequestDTO;
import gr.mod.mil.stock.webservices.dto.PrinterRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrinterController {

    @Autowired
    PrinterRepository printers;

    @Autowired
    PrinterService service;

    @RequestMapping("/api/printers")
    public List<Printer> searchForPrinter(@RequestParam(value="search", required=false) String search) {
        return service.searchPrinters(search);
    }

    @RequestMapping("/api/printers/{publicid}")
    public Printer getPrinterByPublicId(@PathVariable("publicid") String publicid) {
        return printers.findByPublicid(publicid);
    }

    @RequestMapping(value="/api/printers", method = RequestMethod.POST)
    public void addPrinter(@RequestBody PrinterRequestDTO new_printer) {
        service.addPrinter(new_printer.getName());
    }

    @RequestMapping(value="/api/printers/{publicid}", method=RequestMethod.DELETE)
    public void removePrinter(@PathVariable("publicid") String publicid) {
        service.removePrinter(publicid);
    }

    public List<Consumable> getPrinterConsumables(String publicid) {
        return null;
    }

    @RequestMapping(value="/api/printers/{printerid}/consumables", method = RequestMethod.POST)
    public void addPrinterConsumable(@PathVariable("printerid") String printerid, @RequestBody AddConsumableRequestDTO request) {
        service.assignConsumable(printerid, request.getConsumable_id());
    }

    @RequestMapping(value="/api/printers/{printerid}/consumables/{consumableid}", method = RequestMethod.DELETE)
    public void removePrinterConsumable(@PathVariable("printerid") String printer_id, @PathVariable("consumableid") String consumableid) {
        service.removeConsumable(printer_id, consumableid);
    }

}
