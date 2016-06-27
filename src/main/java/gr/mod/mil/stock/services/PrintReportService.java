package gr.mod.mil.stock.services;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import gr.mod.mil.stock.dal.model.ordering.OrderedItem;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import gr.mod.mil.stock.web.dto.consumable.GenericConsumableReportRow;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class PrintReportService {

    @Autowired
    ConsumableRepository consumables;

    @Autowired
    QuantityRepository quantities;

    @Autowired
    ConsumableTransactionsService service;


    public  byte[] PrintRep(String quantity1, String quantity2, String quantity3, Date from, Date to){

        List<GenericConsumableReportRow> rows = service.getConcetratedReport(from, to,
                quantity1,quantity2,quantity3);



        List<List> data = new ArrayList();
       // data.add(new ArrayList<>(
        //        Arrays.asList("Column One", "Column Two", "Column Three", "Column Four")));
       // for (int i = 0; i < rows.size(); i++) {
         //   data.add(new ArrayList<>(
         //           Arrays.asList(rows.get(i).getConsumable().getCode() + rows.get(i).getDeposits() +
          //                  rows.get(i).getWithdrawals() + rows.get(i).getCurrentSupply())));
       // }
        data.add(new ArrayList<>(Arrays.asList("Consumable", "Deposits",
                "Withdrawals", "Current Supply")));
        for (int i = 0; i < rows.size(); i++) {


            data.add(new ArrayList<>(Arrays.asList(rows.get(i).getConsumable().getCode() , rows.get(i).getDeposits() ,
                                     rows.get(i).getWithdrawals() , rows.get(i).getCurrentSupply())));
        }
            PDDocument doc = new PDDocument();
            PDPage page = new PDPage();
            page.setMediaBox(new PDRectangle(PDRectangle.A4.getHeight(),PDRectangle.A4.getWidth()));
            doc.addPage(page);
            float margin = 10;
            float tableWidth = page.getMediaBox().getWidth() - (5 * margin);
            float yStartNewPage = page.getMediaBox().getHeight() - (5 * margin);
            float yStart = yStartNewPage;
            float bottomMargin = 20;
            BaseTable baseTable = null;
            try {
                baseTable = new BaseTable(yStart, yStartNewPage,bottomMargin, tableWidth, margin, doc, page, true, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
            DataTable dataTable = null;
            try {
                dataTable = new DataTable(baseTable, page);
            } catch (IOException e) {

            }
        try {
            dataTable.addListToTable(data, true);
            baseTable.draw();
        } catch (IOException e) {

        }


        OutputStream out = new ByteArrayOutputStream();
        try {
            doc.save(out);
            doc.close();
        } catch (IOException e) {

        }

            return ((ByteArrayOutputStream)out).toByteArray();





    }



}
