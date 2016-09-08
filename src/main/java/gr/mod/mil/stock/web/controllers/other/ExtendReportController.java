package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.services.ExtendedReportService;
import gr.mod.mil.stock.webservices.dto.DepreportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExtendReportController {

    @Autowired
    ExtendedReportService service;

    @RequestMapping("/cdExtendReport")
    public String consumableDepartmentsReport(Model model, @ModelAttribute("depreportDTO") DepreportDTO data,
                                              BindingResult mapping1BindingResult) {


        model.addAttribute("data",data);
        model.addAttribute("report",service.getExtendedReport(data.getFromDate(),data.getToDate()));


        return "cdExtendReport";
    }
}
