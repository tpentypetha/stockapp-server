package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.Printer;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.PrinterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PrinterService {

    @Autowired
    private PrinterRepository printers;

    @Autowired
    private ConsumableRepository consumables;

    public Printer addPrinter(String name) {
        List<Printer> found = printers.findByName(name);
        if (found.isEmpty()) {
            Printer printer = new Printer();
            printer.setName(name);
            printer.setPublicid(UUID.randomUUID().toString());
            return printers.save(printer);
        } else {
            ServiceErrors.failWith(ServiceErrors.PRINTER_ALREADY_EXISTS);
            return null;
        }

    }

    public void removePrinter(String publicid) {
        Printer found = printers.findByPublicid(publicid);
        if (found != null) {
            printers.delete(found);
        } else {
            ServiceErrors.failWith(ServiceErrors.PRINTER_NOT_FOUND);
        }

    }

    public Printer assignConsumable(String printer_id, String consumable_id) throws PrinterConsumableAlreadyExists {
        Printer printer = printers.findByPublicid(printer_id);
        Consumable consumable = consumables.findByPublicid(consumable_id);
        if (getPrinterConsumables(printer.getId())
                .stream()
                .filter(c -> c.equals(consumable))
                .count() > 0 ) {
            throw new PrinterConsumableAlreadyExists();
        }

        printer.getUses().add(consumable);
        consumables.save(consumable);
        return printers.save(printer);
    }

    public Printer removeConsumable(String printer_id, String consumable_id) {
        Printer printer = printers.findByPublicid(printer_id);
        Consumable consumable = consumables.findByPublicid(consumable_id);
        printer.getUses().remove(consumable);
        consumables.save(consumable);
        return printers.save(printer);
    }


    public List<Consumable> getPrinterConsumables(long id) {
        return printers.getPrinterConsumables(id);
    }


    public List<Printer> searchPrinters(String input) {
        return printers.findByName(input);
    }

    public class PrinterConsumableAlreadyExists extends RuntimeException {
        public PrinterConsumableAlreadyExists() {
            super("Printer consumable already exists.");
        }
    }

}
