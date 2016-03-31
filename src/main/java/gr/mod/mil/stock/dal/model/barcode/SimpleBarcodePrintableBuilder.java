package gr.mod.mil.stock.dal.model.barcode;

public class SimpleBarcodePrintableBuilder {
    private String printableText;
    private String barcodeText;

    public SimpleBarcodePrintableBuilder setPrintableText(String printableText) {
        this.printableText = printableText;
        return this;
    }

    public SimpleBarcodePrintableBuilder setBarcodeText(String barcodeText) {
        this.barcodeText = barcodeText;
        return this;
    }

    public SimpleBarcodePrintable createSimpleBarcodePrintable() {
        return new SimpleBarcodePrintable(printableText, barcodeText);
    }
}