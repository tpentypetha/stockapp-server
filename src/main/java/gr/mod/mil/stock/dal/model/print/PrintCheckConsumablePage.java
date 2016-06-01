package gr.mod.mil.stock.dal.model.print;


import gr.mod.mil.stock.dal.model.stock.Cabinet;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrintCheckConsumablePage {

    public List<Cabinet> printables;

    public List<Cabinet> getPrintables() {
        return printables;
    }

    public  PrintCheckConsumablePage(){
        this.printables=new ArrayList<>();
    }

    public void setPrintables(List<Cabinet> printables) {
        this.printables = printables;
    }



    public void addPrintable(Cabinet printable){


        printables.add(printable);
    }
}
