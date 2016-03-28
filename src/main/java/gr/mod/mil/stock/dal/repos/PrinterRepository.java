package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.stock.Consumable;
import gr.mod.mil.stock.dal.model.stock.Printer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrinterRepository extends CrudRepository<Printer, Long> {

    @Query("SELECT P from Printer P where LOWER(P.name) like CONCAT('%', CONCAT(:input, '%') ) ")
    List<Printer> findByName(@Param("input") String name);

    @Query("SELECT P.uses from Printer P left join P.uses as c where P.id = :printerId")
    List<Consumable> getPrinterConsumables(@Param("printerId") long id);

    Printer findByPublicid(String publicid);


}
