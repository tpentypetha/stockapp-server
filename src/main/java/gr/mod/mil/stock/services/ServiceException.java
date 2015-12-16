package gr.mod.mil.stock.services;


public class ServiceException extends RuntimeException {

    private final int code;
    public int getCode() { return code; }

    public ServiceException(int code, String message) {
        super(message);
        this.code = code;
    }

    public ServiceException(ServiceError error) {
        this(error.getCode(), error.getMessage());
    }

}
