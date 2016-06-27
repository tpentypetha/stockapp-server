package gr.mod.mil.stock.dal.model.print;


import gr.mod.mil.stock.dal.model.stock.Cabinet;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import java.util.HashSet;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PrintCheckConsumablePage {

    public HashSet<Cabinet> printables;

    public synchronized HashSet<Cabinet> getPrintables() {
        return printables;
    }

    public PrintCheckConsumablePage(){
        this.printables=new HashSet<>();
    }

    public synchronized void setPrintables(HashSet<Cabinet> printables) {
        this.printables = printables;
    }



    public void addPrintable(Cabinet printable){
        getPrintables().add(printable);
    }

    public void clearPrintables(){
        getPrintables().clear();
    }
}
