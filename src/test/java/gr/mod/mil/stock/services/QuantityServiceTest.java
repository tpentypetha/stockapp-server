package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
import gr.mod.mil.stock.dal.model.Cabinet;
import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.InkColor;
import gr.mod.mil.stock.dal.model.Quantity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = StockApplication.class)
public class QuantityServiceTest {

    @Autowired
    private QuantityService service;

    @Autowired
    private CabinetService cabinetService;

    @Autowired ConsumableService consumableService;

    @Test
    public void testCRUD() {

        Cabinet cabinet = cabinetService.addCabinet("A1");
        Consumable consumable = consumableService.add("H210XKRU", InkColor.MAGENTA, false);
        Quantity quantity = service.addQuantity(cabinet.getPublicid(), consumable.getPublicid(), 0);

        assertNotNull(quantity);

        Quantity loaded = service.getQuantity(quantity.getPublicid());
        assertEquals(loaded.getId(), quantity.getId());

        Quantity updated = service.submitCount(quantity.getPublicid(), 5);
        assertEquals(updated.getAmount(), 5);

        Quantity emptied = service.setEmptyQuantity(updated.getPublicid());
        assertEquals(emptied.getAmount(), 0);

    }

}
