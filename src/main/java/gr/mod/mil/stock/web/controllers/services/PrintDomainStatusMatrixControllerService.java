package gr.mod.mil.stock.web.controllers.services;

import gr.mod.mil.stock.dal.repos.PersonalComputerRepository;
import org.apache.commons.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

@Service
public class PrintDomainStatusMatrixControllerService {

    @Autowired
    PersonalComputerRepository repository;

    public void downloadPDF(final HttpServletResponse response) throws DomainStatusMatrixPrintingException {
        try{
            byte[] pdf = getPDFData(repository.getDomainStausMatrix());
            InputStream is = new ByteArrayInputStream(pdf);
            response.addHeader("Content-Type", "application/force-download");
            response.addHeader("Content-Disposition", "attachment; filename=\"DomainStatusMatrixReport.pdf\"");
            IOUtils.copy(is, response.getOutputStream());
        } catch(IOException exception) {
            throw new DomainStatusMatrixPrintingException();
        }
    }

    private byte[] getPDFData(final List<Object[]> data) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDFont font = PDType1Font.COURIER;
        PDPageContentStream stream = new PDPageContentStream(document, page);
        stream.beginText();
        stream.moveTextPositionByAmount(50,750);
        stream.setFont(font, 18);
        stream.setLeading(20);
        stream.showText("Domain/Status Matrix Report for Personal Computers");
        stream.newLine();
        stream.showText(new Date().toString());
        stream.newLine();
        stream.showText("--------------------------------------------------");
        stream.newLine();
        stream.newLine();
        int index = 1;
        for(Object[] row : data){
            stream.showText(index++ + ") " +row[0] + " " + row[1] + " x " + row[2]);
            stream.newLine();
        }
        stream.endText();
        stream.close();

        OutputStream out = new ByteArrayOutputStream();
        document.save(out);
        document.close();
        return ((ByteArrayOutputStream)out).toByteArray();
    }

    public class DomainStatusMatrixPrintingException extends RuntimeException {
        public DomainStatusMatrixPrintingException(){
            super("Could not print the domain status matrix report.");
        }
    }

}
