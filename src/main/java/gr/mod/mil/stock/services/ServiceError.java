package gr.mod.mil.stock.services;

public class ServiceError {

    private final int code;
    public int getCode() { return code; }

    private final String message;
    public String getMessage() { return message; }

    public ServiceError(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
