package gr.mod.mil.stock.services;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;

@Service
public class BarcodeService {

    @Autowired
    ApplicationContext ctx;

    public static final String IMG_FORMAT = "png";

    public byte[] getBarcodeFrom(String text, int width, int height) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        BitMatrix matrix = new Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height);
        MatrixToImageWriter.writeToStream(matrix, IMG_FORMAT, out);
        return out.toByteArray();
    }



}
