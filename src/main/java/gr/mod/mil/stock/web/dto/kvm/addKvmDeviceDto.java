package gr.mod.mil.stock.web.dto.kvm;


public class addKvmDeviceDto {

    String modelName,status,numofdevices;

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNumofdevices() {
        return numofdevices;
    }

    public void setNumofdevices(String numofdevices) {
        this.numofdevices = numofdevices;
    }
}
