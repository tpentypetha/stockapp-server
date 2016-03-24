package gr.mod.mil.stock.web.controllers.services;

import gr.mod.mil.stock.dal.model.OrderHistory;
import gr.mod.mil.stock.services.OrderingService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class OrderingControllerService {

    @Autowired
    OrderingService service;

    public void downloadPDF(OrderHistory history, HttpServletResponse response) throws IOException {
        byte[] pdf = service.printOrderHistory(history);
        InputStream is = new ByteArrayInputStream(pdf);
        response.addHeader("Content-Type", "application/force-download");
        String name = "Order_"+history.getWhen().toString().replace(' ','_')+".pdf";
        response.addHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
        IOUtils.copy(is, response.getOutputStream());
    }

}
