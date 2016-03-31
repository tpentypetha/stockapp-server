package gr.mod.mil.stock.dal.model.barcode;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BarcodePage {

    public final static int MAX_PRINTABLES = 21;

    private final List<BarcodePrintable> printables;

    public List<BarcodePrintable> getPrintables() {
        return printables;
    }

    public BarcodePage() {
        this.printables = new ArrayList<>();
    }

    /**
     * Add a barcode printable <i>n</i> times.
     * Will throw a {@link PageFullException} if the page has
     * already more than {@link BarcodePage#MAX_PRINTABLES} printables.
     *
     * @param printable
     * @param n
     *
     * @throws PageFullException
     */
    public void addPrintable(BarcodePrintable printable, int n) throws PageFullException {
        if (!canAdd(n)) {
            throw new PageFullException(getRemainder());
        }
        for(int i=0; i<n; i++){
            printables.add(printable);
        }
    }

    private boolean canAdd(int requested){ return printables.size() + requested <= MAX_PRINTABLES; }

    private int getRemainder() { return MAX_PRINTABLES - printables.size(); }

    /**
     * Clears the page.
     */
    public void clear(){
        printables.clear();
    }

    public class PageFullException extends RuntimeException{
        private final int remainder;
        public int getRemainder() { return remainder; }

        public PageFullException(int remainder){
            super("Page is full. You can add up to " + remainder);
            this.remainder = remainder;
        }
    }

}
