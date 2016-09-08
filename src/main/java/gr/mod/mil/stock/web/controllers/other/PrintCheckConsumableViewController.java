package gr.mod.mil.stock.web.controllers.other;


import gr.mod.mil.stock.dal.model.print.PrintCheckConsumablePage;
import gr.mod.mil.stock.dal.repos.CabinetRepository;

import gr.mod.mil.stock.services.PrintCheckConsumableService;
import gr.mod.mil.stock.web.dto.cabinet.PrintCabinetDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class PrintCheckConsumableViewController {

    @Autowired
    PrintCheckConsumablePage page;

    @Autowired
    CabinetRepository repo;

    @Autowired
    PrintCheckConsumableService service;

    @RequestMapping("/printCheckConsumable")
    public String getView(
            Model model) {
        model.addAttribute("cabinets", page.getPrintables());

        return "printCheckConsumable";
    }


    @RequestMapping(value = "/addToPrintCheckConsumable", method = RequestMethod.POST)
    public String processPost(@ModelAttribute("printCabinetDTO") PrintCabinetDTO data, Model model, String redirect) {
        String message;
        model.addAttribute(data.getCabinetid());
        if(service.isAdded(data.getCabinetid())){
            message = "This cabinet has already been added.";
        }else{
            service.addToPrint(data.getCabinetid());
            message = "The cabinet has been added.";
        }

        if(redirect.endsWith("?null")) {
            redirect = redirect.substring(0, redirect.indexOf("?null"));
            Map<String, String> args = new LinkedHashMap<>();
            args.put("message", message);
            return makeRedirectString(args, redirect);
        }
        else{
            if(redirect.contains("?")){
                Map<String, String> args = splitQuery(redirect.substring(redirect.indexOf("?")+1));
                redirect = redirect.substring(0, redirect.indexOf("?"));
                if(args == null)
                    return null;
                args.put("message", message);
                return makeRedirectString(args, redirect);
            }
            else{
                Map<String, String> args = new LinkedHashMap<>();
                args.put("message", message);
                return makeRedirectString(args, redirect);
            }
        }
    }


    @RequestMapping(value = "/clearPrintables", method = RequestMethod.POST)
    public String processPost(String redirect) {
        String message = "Cleared printables.";

        page.clearPrintables();
        if(redirect.endsWith("?null"))
            redirect = redirect.substring(0, redirect.indexOf("?null"));

        if(redirect.endsWith("?null")) {
            redirect = redirect.substring(0, redirect.indexOf("?null"));
            Map<String, String> args = new LinkedHashMap<>();
            args.put("message", message);
            return makeRedirectString(args, redirect);
        }
        else{
            if(redirect.contains("?")){
                Map<String, String> args = splitQuery(redirect.substring(redirect.indexOf("?")+1));
                redirect = redirect.substring(0, redirect.indexOf("?"));
                if(args == null)
                    return null;
                args.put("message", message);
                return makeRedirectString(args, redirect);
            }
            else{
                Map<String, String> args = new LinkedHashMap<>();
                args.put("message", message);
                return makeRedirectString(args, redirect);
            }
        }
    }

    private String makeRedirectString(Map<String, String> args, String uri){
        String redirect = "redirect:" + uri;
        if(uri == null)
            return null;
        if(args != null) {
            for (Map.Entry<String, String> en : args.entrySet()) {
                if(redirect.contains("?")){
                    if(redirect.endsWith("&"))
                        redirect += en.getKey() + "=" + en.getValue();
                    else
                        redirect += "&" + en.getKey() + "=" + en.getValue();
                }else{
                    redirect += "?" + en.getKey() + "=" + en.getValue();
                }
            }
        }
        return redirect;
    }

    public static Map<String, String> splitQuery(String query){
        Map<String, String> query_pairs = new LinkedHashMap<String, String>();
        String[] pairs = query.split("&");
        try {
            for (String pair : pairs) {
                int idx = pair.indexOf("=");
                query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                        URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
            }
        }catch(UnsupportedEncodingException e){
            return null;
        }
        return query_pairs;
    }
}
