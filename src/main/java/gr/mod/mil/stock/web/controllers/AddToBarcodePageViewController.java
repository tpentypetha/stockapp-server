package gr.mod.mil.stock.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddToBarcodePageViewController {

    @RequestMapping("/addToBarcodePage")
    public String getView(
            Model model,
            @RequestParam("printableText")String printableText,
            @RequestParam("barcodeText")String barcodeText){
        model.addAttribute("printableText", printableText);
        model.addAttribute("barcodeText", barcodeText);
        return "addBarcodeToPage";
    }

}
