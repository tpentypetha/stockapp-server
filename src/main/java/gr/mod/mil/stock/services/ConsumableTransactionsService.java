package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.Consumable;
import gr.mod.mil.stock.dal.model.ConsumableTransaction;
import gr.mod.mil.stock.dal.model.TransactionIndicator;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.ConsumableTransactionsRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import gr.mod.mil.stock.web.dto.GenericConsumableReportRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        } else {
            transaction.setWithdrawamount(amount);
            transaction.setDepositamount(0);
        }
        transaction.setWhen(new Date());

        return transactions.save(transaction);
    }

    public List<GenericConsumableReportRow> getConcetratedReport(Date from, Date to) {
        List<Object[]> data = transactions.getTransactions(from, to);
        List<GenericConsumableReportRow> list = new ArrayList<>();
        data.forEach(row -> {
            GenericConsumableReportRow reportRow = new GenericConsumableReportRow();
            reportRow.setConsumable(consumables.findOne(Long.parseLong(String.valueOf(row[0]))));
            reportRow.setWithdrawals(String.valueOf(row[1]));
            reportRow.setDeposits(String.valueOf(row[2]));
            reportRow.setCurrentSupply(String.valueOf(quantities.getCurrentSupply(Long.parseLong(String.valueOf(row[0])))));
            list.add(reportRow);
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
