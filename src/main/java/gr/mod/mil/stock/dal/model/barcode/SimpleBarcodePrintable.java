package gr.mod.mil.stock.dal.model.barcode;

public class SimpleBarcodePrintable implements BarcodePrintable {

    private final String printableText;
    private final String barcodeText;

    public String getPrintableText() {
        return printableText;
    }

    public String getBarcodeText() {
        return barcodeText;
    }

    public SimpleBarcodePrintable(String printableText, String barcodeText) {
        this.printableText = printableText;
        this.barcodeText = barcodeText;
    }
}
