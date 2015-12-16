package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.InkColor;
import gr.mod.mil.stock.dal.model.Printer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StockApplication.class)
public class PrinterServiceTest {

    @Autowired
    private PrinterService printerService;

    @Autowired
    private ConsumableService consumableService;

    @Test
    public void testCrud() {
        Printer printer = printerService.addPrinter("test 15X ab");
        assertNotNull(printer);

        List<Printer> printers = printerService.searchPrinters("15");
        assertFalse(printers.isEmpty());

        Printer test = printerService.searchPrinters("test 15X ab").get(0);
        printerService.removePrinter(test.getPublicid());
        assertTrue(printerService.searchPrinters("test 15X ab").isEmpty());
    }

    @Test
    public void testConsumable() {
        Printer printer = printerService.addPrinter("test 15x ab");
        assertNotNull(printer);

        Consumable ink = consumableService.add("H210XKRU", InkColor.MAGENTA, 2, false);
        printerService.assignConsumable(printer.getPublicid(), ink.getPublicid());

        printer = printerService.searchPrinters("test 15x ab").get(0);
        List<Consumable> inks = printerService.getPrinterConsumables(printer.getId());
        assertTrue(inks.contains(ink));

        printerService.removeConsumable(printer.getPublicid(), ink.getPublicid());
        printer = printerService.searchPrinters("test 15x ab").get(0);
        assertTrue(! printerService.getPrinterConsumables(printer.getId()).contains(ink));

        consumableService.markAsObsolete(ink.getPublicid());
        printerService.removePrinter(printer.getPublicid());

        assertTrue(printerService.searchPrinters("test 15x ab").isEmpty());
        assertTrue(!consumableService.searchByCode("H210XKRU").isEmpty());
        assertTrue(consumableService.searchByCode("H210XKRU").get(0).getQuantity_available() == 0);
        assertFalse(consumableService.searchByCode("H210XKRU").get(0).getCritical());
    }

}
