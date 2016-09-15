package gr.mod.mil.stock.web.controllers.computers;

import gr.mod.mil.stock.dal.model.devices.PersonalComputer;
import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



/*
Xrisimopoioume to annotation @Controller gia tin class pou periexei tis methodous kathe selidas html (POST,GET ktl)
 */
@Controller
public class PersonalComputerViewController {

    @Autowired
    LogService logger;

    // import to repository ton pcs (Table stin database)
    @Autowired
    PersonalComputerRepository repository;

    // me to @RequestMapping zitame apo to programma na kanei map tin methodo /pcs i opoia epistrefei tin pcs.html
    @RequestMapping("/pcs")
    public String view(Model model, @RequestParam(value = "query", required = false) String query){
        if(query != null && ! query.isEmpty()) {
            // kaloume apo to repository ton personalComputers tin methodo getByPublicId me tin parametro pou mas irthe (quert)
            PersonalComputer pc=repository.getByPublicid(query);

            // Prosthetoume stin html selida to object
            model.addAttribute("pcs",pc );
        }
        logger.log("visited the Personal Computer page");
        return "pcs";
    }

}
