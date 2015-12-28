package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
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
public class ConsumableServiceTest {

    @Autowired
    private ConsumableService service;

    @Test
    public void testService() {
        Consumable inserted = service.add("H210XKRU", InkColor.CYAN, false);
        assertNotNull(inserted);

        Consumable updated = service.add("H210XKRU", InkColor.YELLOW, false);
        assertTrue(updated.getColor().equals(InkColor.YELLOW));

        List<Consumable> found = service.searchByCode("210");
        assertTrue(! found.isEmpty());

        Consumable first = found.get(0);
        service.markAsObsolete(first.getPublicid());
        assertTrue(!service.searchByCode("H210XKRU").isEmpty());
        assertFalse(service.searchByCode("H210XKRU").get(0).getCritical());
    }

}
