package gr.mod.mil.stock.web.controllers.KVM;

import gr.mod.mil.stock.dal.repos.KvmRepository;
import gr.mod.mil.stock.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Controller
public class KvmsController {

    @Autowired
    LogService logger;

    @Autowired
    KvmRepository repository;


    @RequestMapping("/kvms")
    public String view(Model model, @RequestParam(value = "query", required = false) String query){
        if(query != null && ! query.isEmpty()) {
            model.addAttribute("kvms", repository.findByPublicid(query));
        }

        //Test values begin
        logger.log(UUID.randomUUID().toString());
        logger.log(UUID.randomUUID().toString());
        logger.log(UUID.randomUUID().toString());
        logger.log(UUID.randomUUID().toString());
        //Test values end
        logger.log("visited the KVMs page");
        return "kvms";
    }

}
