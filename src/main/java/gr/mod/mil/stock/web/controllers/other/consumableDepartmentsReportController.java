package gr.mod.mil.stock.web.controllers.other;

import gr.mod.mil.stock.dal.repos.DepartmentsRepository;
import gr.mod.mil.stock.services.BriefReportService;
import gr.mod.mil.stock.services.LogService;
import gr.mod.mil.stock.webservices.dto.DepreportDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class consumableDepartmentsReportController {

    @Autowired
    LogService logger;

    @Autowired
    DepartmentsRepository deptrepo;



    @RequestMapping("/consumableDepartmentsReport")
    public String consumableDepartmentsReport(Model model) {

        model.addAttribute("depts",deptrepo.findAll());
        return "consumableDepartmentsReport";
    }

    @RequestMapping(value="/briefreport",method = RequestMethod.POST)
    public String getbriefReport(Model model,@ModelAttribute("depreportDTO") DepreportDTO data,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult mapping1BindingResult) {

        model.addAttribute("depts",deptrepo.findAll());
        model.addAttribute("depreportDTO",data);

        redirectAttributes.addFlashAttribute("depreportDTO",data);
        return "redirect:cdBriefReport";
    }

    @RequestMapping(value="/extendreport",method = RequestMethod.POST)
    public String getextendReport(Model model,@ModelAttribute("depreportDTO") DepreportDTO data,
                                 RedirectAttributes redirectAttributes,
                                 BindingResult mapping1BindingResult) {

        model.addAttribute("depts",deptrepo.findAll());
        model.addAttribute("depreportDTO",data);

        redirectAttributes.addFlashAttribute("depreportDTO",data);
        return "redirect:cdExtendReport";
    }


    @RequestMapping(value="/depreport",method = RequestMethod.POST)
    public String getDepartmentReport(Model model,@ModelAttribute("depreportDTO") DepreportDTO data,
                                  RedirectAttributes redirectAttributes,
                                  BindingResult mapping1BindingResult) {

        model.addAttribute("depts",deptrepo.findAll());
        model.addAttribute("depreportDTO",data);

        redirectAttributes.addFlashAttribute("depreportDTO",data);
        return "redirect:cdDepReport";
    }






}
