package gr.mod.mil.stock.dal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Device {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) @JsonIgnore
    private Long id;
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    @Enumerated(EnumType.STRING)
    private DeviceType type;
    public DeviceType getType() { return type; }
    public void setType(DeviceType type) { this.type = type; }

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

    private String cpu;
    public String getCpu() { return cpu; }
    public void setCpu(String cpu ) { this.cpu = cpu; }

    private String ram;
    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram;}

    private String other;
    public String getOther() { return other; }
    public void setOther(String other) { this.other = other; }

}
