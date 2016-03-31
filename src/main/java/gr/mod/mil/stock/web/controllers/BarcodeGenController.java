package gr.mod.mil.stock.web.controllers;

import gr.mod.mil.stock.dal.model.barcode.BarcodePage;
import gr.mod.mil.stock.dal.model.barcode.SimpleBarcodePrintableBuilder;
import gr.mod.mil.stock.web.dto.AddBarcodeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BarcodeGenController {

    @Autowired
    BarcodePage page;

    @RequestMapping("/barcodeGen")
    public String getView(
            Model model,
            @RequestParam(value = "pageFull", required = false) boolean pageFull,
            @RequestParam(value = "remainder", required = false) Integer remainder){
        model.addAttribute("barcodes", page.getPrintables());
        if (pageFull) {
            model.addAttribute("pageFull", pageFull);
            model.addAttribute("remainder", remainder);
        }
        return "barcodeGen";
    }

    @RequestMapping(value = "/barcodeGen", method = RequestMethod.POST)
    public String addBarcode(@ModelAttribute("addBarcodeDto")AddBarcodeDTO data){
        try {
            page.addPrintable(new SimpleBarcodePrintableBuilder()
                    .setPrintableText(data.getPrintableText())
                    .setBarcodeText(data.getBarcodeText()).createSimpleBarcodePrintable(), data.getMultitude());
            return "redirect:/barcodeGen";
        } catch(BarcodePage.PageFullException ex) {
            return "redirect:/barcodeGen?pageFull=true&remainder="+ex.getRemainder();
        }
    }

}
