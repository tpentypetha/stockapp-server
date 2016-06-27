package gr.mod.mil.stock.web.controllers.barcodes;

import gr.mod.mil.stock.services.BarcodeService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;

@Controller
public class BarcodeController {

    @Autowired
    BarcodeService service;

    @RequestMapping("/barcode")
    public @ResponseBody void getBarcode(
            HttpServletResponse response,
            @RequestParam("text") String text) throws Exception {
        ByteArrayInputStream ios = new ByteArrayInputStream(service.getBarcodeFrom(text, 80, 60));
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        IOUtils.copy(ios, response.getOutputStream());
    }

}
