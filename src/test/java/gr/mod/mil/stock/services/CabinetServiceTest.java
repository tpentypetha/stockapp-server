package gr.mod.mil.stock.services;

import gr.mod.mil.stock.StockApplication;
import gr.mod.mil.stock.dal.model.stock.Cabinet;
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



}
