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

import java.util.List;
import java.util.UUID;

@Service
public class TranferQuantity {
    @Autowired
    private CabinetRepository cabinets;

    @Autowired
    private QuantityRepository quantities;

    @Autowired
    private ConsumableRepository consumables;

    @Autowired
    ConsumableTransactionsService transactions;


    public void TranferQuantity(String cabinetid,
                                String consumableid,
                                String totalamount,
                                String Transferamount,
                                String ToCabinetid,String quantityid){

        String s="fsdfsdfs";

        Cabinet From_cabinet = cabinets.findByPublicid(cabinetid);
        Cabinet To_cabinet = cabinets.findByPublicid(ToCabinetid);
        Consumable consumable = consumables.findByPublicid(consumableid);

        if (consumableExists(To_cabinet, consumable)) {

           List <Quantity> To_cabinet_consumables =  To_cabinet.getQuantities();

            for (int i=0;i<To_cabinet_consumables.size();i++){
                if(To_cabinet_consumables.get(i).getConsumable().equals(consumable)){
                    Quantity To_cabinet_quantity =To_cabinet_consumables.get(i);
                    int previousAmount = To_cabinet_quantity.getAmount();
                    int sum = previousAmount + Integer.valueOf(Transferamount);
                    To_cabinet_quantity.setAmount(sum);
                    quantities.save(To_cabinet_quantity);

                }

            }




        }
        else{
            Quantity quantity = new Quantity();
            quantity.setConsumable(consumable);
            quantity.setAmount(Integer.valueOf(Transferamount));
            quantity.setPublicid(UUID.randomUUID().toString());


            To_cabinet.getQuantities().add(quantities.save(quantity));
            cabinets.save(To_cabinet);

        }

        if(Integer.valueOf(Transferamount)<quantities.findByPublicid(quantityid).getAmount()){


            Quantity quantityFromCabinet =  quantities.findByPublicid(quantityid);
            int previousAmount = quantityFromCabinet.getAmount();
            int diff = previousAmount - Integer.valueOf(Transferamount);
            quantityFromCabinet.setAmount(diff);
            quantities.save(quantityFromCabinet);
        }else {
            quantities.delete(quantities.findByPublicid(quantityid));
        }


    }

    private boolean consumableExists(Cabinet cabinet, Consumable consumable) {
        return cabinet.getQuantities()
                .stream()
                .filter(q -> q.getConsumable().equals(consumable))
                .count() > 0;
    }


}
