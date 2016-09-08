package gr.mod.mil.stock.web.controllers.cabinets;

import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.DepartmentsRepository;
import gr.mod.mil.stock.services.CabinetService;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CabinetViewController {

    @Autowired
    CabinetRepository repo;

    @Autowired
    DepartmentsRepository deptrepo;

    @Autowired
    LogService logger;

    @RequestMapping(value = "/cabinet", method = RequestMethod.GET)
    public String render(@RequestParam("id") String cabinetid, Model model,
                         @RequestParam(value = "error", required = false) boolean error){
        model.addAttribute("cabinet", repo.findByPublicid(cabinetid));
        model.addAttribute("depts",deptrepo.findAll());
        model.addAttribute("error", error);
        logger.log("visited Cabinet page");
        return "cabinet";
    }

}
