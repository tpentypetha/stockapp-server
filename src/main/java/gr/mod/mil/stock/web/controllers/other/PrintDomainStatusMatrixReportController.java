package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.services.SecurityService;
import gr.mod.mil.stock.web.controllers.services.PrintDomainStatusMatrixControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
public class PrintDomainStatusMatrixReportController {

    @Autowired
    PrintDomainStatusMatrixControllerService service;

    @Autowired
    LogService logger;

    @RequestMapping("/printDomainStatusMatrixReport")
    public void print(HttpServletResponse response)
            throws PrintDomainStatusMatrixControllerService.DomainStatusMatrixPrintingException {
        service.downloadPDF(response);
        logger.log("requested a print for the Domain Status Matrix Report page");
    }

}
