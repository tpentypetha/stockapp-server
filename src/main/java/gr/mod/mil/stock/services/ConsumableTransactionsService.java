package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.ConsumableTransaction;
import gr.mod.mil.stock.dal.model.stock.TransactionIndicator;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.ConsumableTransactionsRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import gr.mod.mil.stock.web.dto.GenericConsumableReportRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ConsumableTransactionsService {

    @Autowired
    ConsumableTransactionsRepository transactions;

    @Autowired
    ConsumableRepository consumables;

    @Autowired
    QuantityRepository quantities;

    public ConsumableTransaction record(Consumable consumable, TransactionIndicator indicator, int amount) {
        ConsumableTransaction transaction = new ConsumableTransaction();
        transaction.setConsumable(consumable);
        if (indicator.equals(TransactionIndicator.DEPOSIT)){
            transaction.setDepositamount(amount);
            transaction.setWithdrawamount(0);
            transaction.setDelete_amount(0);
        } else if(indicator.equals(TransactionIndicator.WITHDRAWAL)) {
            transaction.setWithdrawamount(amount);
            transaction.setDepositamount(0);
            transaction.setDelete_amount(0);
        }
        else{
            transaction.setDelete_amount(amount);
            transaction.setDepositamount(0);
            transaction.setWithdrawamount(0);

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

}
