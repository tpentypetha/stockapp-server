package gr.mod.mil.stock.services;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.ConsumableTransaction;
import gr.mod.mil.stock.dal.model.stock.TransactionIndicator;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.ConsumableTransactionsRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import gr.mod.mil.stock.web.dto.consumable.GenericConsumableReportRow;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

@Service
public class ConsumableTransactionsService {

    @Autowired
    ConsumableTransactionsRepository transactions;

    @Autowired
    ConsumableRepository consumables;

    @Autowired
    QuantityRepository quantities;

    public ConsumableTransaction record(Consumable consumable, TransactionIndicator indicator, int amount,long deptid) {
        ConsumableTransaction transaction = new ConsumableTransaction();
        transaction.setConsumable(consumable);
        if (indicator.equals(TransactionIndicator.DEPOSIT)){
            transaction.setDepositamount(amount);
            transaction.setWithdrawamount(0);
            transaction.setDelete_amount(0);
            transaction.setDeptid(1);

        } else if(indicator.equals(TransactionIndicator.WITHDRAWAL)) {
            transaction.setWithdrawamount(amount);
            transaction.setDepositamount(0);
            transaction.setDelete_amount(0);
            transaction.setDeptid(deptid);
        }
        else{
            transaction.setDelete_amount(amount);
            transaction.setDepositamount(0);
            transaction.setWithdrawamount(0);
            transaction.setDeptid(1);

        }
        transaction.setWhen(new Date());

        return transactions.save(transaction);
    }

    public List<GenericConsumableReportRow> getConcetratedReport(Date from, Date to,String quantity1,String quantity2,String quantity3) {




        Calendar c = Calendar.getInstance();
        c.setTime(to);
        c.add(Calendar.DATE,1);

        List<Object[]> data = transactions.getTransactions(from, c.getTime());
        List<GenericConsumableReportRow> list = new ArrayList<>();

            data.forEach(row -> {

                    GenericConsumableReportRow reportRow = new GenericConsumableReportRow();
                    reportRow.setConsumable(consumables.findOne(Long.parseLong(String.valueOf(row[0]))));
                    reportRow.setWithdrawals(String.valueOf(row[1]));
                    reportRow.setDeposits(String.valueOf(row[2]));
                try {
                    reportRow.setCurrentSupply(String.valueOf(quantities.getCurrentSupply(Long.parseLong(String.valueOf(row[0])))));
                }catch (Exception e){
                    reportRow.setCurrentSupply("0");
                }
                   // if(!reportRow.getDeposits().equals("0") && !reportRow.getWithdrawals().equals("0")) {

                if(Integer.valueOf(reportRow.getDeposits())> Integer.valueOf(quantity1)
                        && Integer.valueOf(reportRow.getWithdrawals())> Integer.valueOf(quantity2)
                        && Integer.valueOf(reportRow.getCurrentSupply())<= Integer.valueOf(quantity3)) {
                    list.add(reportRow);
                }
                   // }

            });


        return list;
    }

    public List<GenericConsumableReportRow> getTotalSupplies(){
        List<Object[]> data = quantities.getAllCurrentSupplies();
        List<GenericConsumableReportRow> list = new ArrayList<>();
        data.forEach(row -> {
            GenericConsumableReportRow reportRow = new GenericConsumableReportRow();
            reportRow.setConsumable(consumables.findOne(Long.parseLong(String.valueOf(row[0]))));
            reportRow.setCurrentSupply(String.valueOf(row[1]));
            list.add(reportRow);
        });
        return list;
    }



   public byte[] printReport(List<GenericConsumableReportRow> rows) {
        List<List> data = new ArrayList();
        // data.add(new ArrayList<>(
        //        Arrays.asList("Column One", "Column Two", "Column Three", "Column Four")));
        // for (int i = 0; i < rows.size(); i++) {
        //   data.add(new ArrayList<>(
        //           Arrays.asList(rows.get(i).getConsumable().getCode() + rows.get(i).getDeposits() +
        //                  rows.get(i).getWithdrawals() + rows.get(i).getCurrentSupply())));
        // }
        data.add(new ArrayList<>(Arrays.asList("Consumable", "Current Supply")));
        for (int i = 0; i < rows.size(); i++) {


            data.add(new ArrayList<>(Arrays.asList(rows.get(i).getConsumable().getCode(),
                     rows.get(i).getCurrentSupply())));
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
