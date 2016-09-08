package gr.mod.mil.stock.services;


import gr.mod.mil.stock.dal.model.stock.Cabinet;
import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.Quantity;
import gr.mod.mil.stock.dal.model.stock.TransactionIndicator;
import gr.mod.mil.stock.dal.repos.CabinetRepository;
import gr.mod.mil.stock.dal.repos.ConsumableRepository;
import gr.mod.mil.stock.dal.repos.QuantityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class QuantityService {

    @Autowired
    private CabinetRepository cabinets;

    @Autowired
    private QuantityRepository quantities;

    @Autowired
    private ConsumableRepository consumables;

    @Autowired
    ConsumableTransactionsService transactions;



    public Quantity getQuantity(String quantityid){
        return quantities.findByPublicid(quantityid);
    }

    public Quantity addQuantity(String cabinetid, String consumableid, int initialAmount)
        throws ConsumableQuantityAlreadyExists {
        Cabinet cabinet = cabinets.findByPublicid(cabinetid);
        Consumable consumable = consumables.findByPublicid(consumableid);

        if (consumableExists(cabinet, consumable)) {
            throw new ConsumableQuantityAlreadyExists(cabinet, consumable);
        }

        Quantity quantity = new Quantity();
        quantity.setConsumable(consumable);
        quantity.setAmount(initialAmount);
        quantity.setPublicid(UUID.randomUUID().toString());
        Quantity saved = quantities.save(quantity);

        cabinet.getQuantities().add(saved);
        cabinets.save(cabinet);
        transactions.record(consumable, TransactionIndicator.DEPOSIT, initialAmount,0);
        return saved;
    }

    public Quantity setEmptyQuantity(String quantityid) {
        Quantity quantity = quantities.findByPublicid(quantityid);
        quantity.setEmpty();
        return quantities.save(quantity);
    }

    public Quantity submitCount(String quantityid, int amount,long deptid){
        Quantity quantity = quantities.findByPublicid(quantityid);

        int previousAmount = quantity.getAmount();
        int diff = previousAmount - amount;
        TransactionIndicator indicator = diff < 0 ? TransactionIndicator.DEPOSIT : TransactionIndicator.WITHDRAWAL;
        int transaction_amount = Math.abs(diff);

        transactions.record(quantity.getConsumable(), indicator, transaction_amount,deptid);

        quantity.setAmount(amount);
        return quantities.save(quantity);
    }

    public void RemoveQuantity(String quantityid){
        Quantity quantity = quantities.findByPublicid(quantityid);
        quantities.delete(quantity.getId());
        transactions.record(quantity.getConsumable(),TransactionIndicator.DELETE,quantity.getAmount(),0);


    }

    private boolean consumableExists(Cabinet cabinet, Consumable consumable) {
        return cabinet.getQuantities()
                .stream()
                .filter(q -> q.getConsumable().equals(consumable))
                .count() > 0;
    }

    public class ConsumableQuantityAlreadyExists extends RuntimeException {

        private final Consumable consumable;
        public Consumable getConsumable() { return consumable; }

        private final Cabinet cabinet;
        public Cabinet getCabinet() { return cabinet; }

        public ConsumableQuantityAlreadyExists(Cabinet cabinet, Consumable consumable) {
            super("Cabinet " + cabinet.getName() + " already contains a quantity with consumable: " + consumable.getCode());
            this.cabinet = cabinet;
            this.consumable = consumable;
        }
    }

}
