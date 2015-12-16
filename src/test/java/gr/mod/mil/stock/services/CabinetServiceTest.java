package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.InkColor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StockApplication.class)
public class CabinetServiceTest {

    @Autowired
    private CabinetService service;

    @Autowired
    private ConsumableService consumableService;

    @Test
    public void testCrud() {
        Cabinet a1 = service.addCabinet("A1");
        assertNotNull(a1);

        List<Cabinet> found = service.searchByName("A");
        assertTrue(! found.isEmpty());

        service.removeCabinet(a1.getPublicid());
        List<Cabinet> should_be_empty = service.searchByName("A1");
        assertTrue(should_be_empty.isEmpty());
    }

    @Test
    public void testConsumable() {
        Cabinet cabinet = service.addCabinet("A1");
        assertNotNull(cabinet);

        Consumable ink = consumableService.add("H210XKRU", InkColor.MAGENTA, 2, false);
        service.assignConsumable(cabinet.getPublicid(), ink.getPublicid());

        cabinet = service.searchByName("A1").get(0);
        List<Consumable> inks = service.getCabinetConsumables(cabinet.getId());
        assertTrue(inks.contains(ink));

        service.removeConsumable(cabinet.getPublicid(), ink.getPublicid());
        cabinet = service.searchByName("A1").get(0);
        assertTrue(! service.getCabinetConsumables(cabinet.getId()).contains(ink));

        consumableService.markAsObsolete(ink.getPublicid());
        service.removeCabinet(cabinet.getPublicid());

        assertTrue(service.searchByName("A1").isEmpty());
        assertTrue(!consumableService.searchByCode("H210XKRU").isEmpty());
        assertTrue(consumableService.searchByCode("H210XKRU").get(0).getQuantity_available() == 0);
        assertFalse(consumableService.searchByCode("H210XKRU").get(0).getCritical());


    }

}
