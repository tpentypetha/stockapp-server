package gr.mod.mil.stock.dal.model.devices;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@MappedSuperclass
public abstract class Device {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Enumerated(EnumType.STRING)
    private DeviceStatus status;
    public DeviceStatus getStatus() { return status; }
    public void setStatus(DeviceStatus status) { this.status = status;}

    private String position;
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    private String modelName;
    public String getModelName() { return modelName;}
    public void setModelName(String modelName) { this.modelName = modelName; }

    private String serialNum;
    public String getSerialNum() { return serialNum; }
    public void setSerialNum(String serialNum) { this.serialNum = serialNum; }

    private String partNum;
    public String getPartNum() { return partNum; }
    public void setPartNum(String partNum) { this.partNum = partNum; }

    private String publicid;
    public String getPublicid() { return publicid; }
    public void setPublicid(String publicid) { this.publicid = publicid; }

    public Device(DeviceStatus status, String position, String modelName, String serialNum, String partNum) {
        this.status = status;
        this.position = position;
        this.modelName = modelName;
        this.serialNum = serialNum;
        this.partNum = partNum;
    }
}
