package gr.mod.mil.stock.dal.repos;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PrinterDevice;
import gr.mod.mil.stock.dal.model.devices.PrinterTechnology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface PrinterDeviceRepository extends CrudRepository<PrinterDevice, Long>{

    PrinterDevice findByPublicid(String publicid);


    @Query( "SELECT P " +
            "FROM PrinterDevice P " +
            "WHERE P.technology = :technology " +
            "AND P.status = :status")
    List<PrinterDevice> getPrinterByTechnologyAndStatus(@Param("technology") PrinterTechnology technology, @Param("status") DeviceStatus status);

    @Query( "SELECT P " +
            "FROM PrinterDevice P " +
            "WHERE P.belongs_to = :belongs_to ")
    List<PrinterDevice> getPrinter_thatBelongsTo(@Param("belongs_to") long id);

}
