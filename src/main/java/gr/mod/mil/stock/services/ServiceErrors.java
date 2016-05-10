package gr.mod.mil.stock.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceErrors {

    private final static Logger log = LoggerFactory.getLogger(ServiceErrors.class);

    public final static ServiceError PRINTER_NOT_FOUND = new ServiceError(0001, "err_printer_not_found");
    public final static ServiceError PRINTER_ALREADY_EXISTS = new ServiceError(0002, "err_printer_already_exists");
    public final static ServiceError CABINET_ALREADY_EXISTS = new ServiceError(0003, "err_CABINET_already_exists");
    public final static ServiceError CABINET_NOT_FOUND = new ServiceError(0004, "err_cabinet_not_found");
    public final static ServiceError CONSUMABLE_ALREADY_EXISTS = new ServiceError(0005, "err_consumable_already_exists");
    public final static ServiceError CONSUMABLE_NOT_FOUND= new ServiceError(0006, "err_cabinet_not_found");

    public static void failWith(ServiceError error) {
        log.error(error.getMessage());
        throw new ServiceException(error);
    }
}
