package gr.mod.mil.stock.web.dto;

public class AddBarcodeDTO {

    private String printableText;
    private String barcodeText;
    private int multitude;

    public String getPrintableText() {
        return printableText;
    }

    public void setPrintableText(String printableText) {
        this.printableText = printableText;
    }

    public String getBarcodeText() {
        return barcodeText;
    }

    public void setBarcodeText(String barcodeText) {
        this.barcodeText = barcodeText;
    }

    public int getMultitude() {
        return multitude;
    }

    public void setMultitude(int multitude) {
        this.multitude = multitude;
    }
}
