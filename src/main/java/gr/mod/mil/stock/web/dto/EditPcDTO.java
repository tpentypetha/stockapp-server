package gr.mod.mil.stock.web.dto;

import gr.mod.mil.stock.dal.model.devices.CaseType;
import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.PersonalComputerDomain;

public class EditPcDTO {

    private DeviceStatus status;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String position;
    private int ram;
    private int memory;
    private String cpu;
    private String cpuSocket;
    private PersonalComputerDomain domain;
    private CaseType caseType;
    private String publicid;

    public DeviceStatus getStatus() {
        return status;
    }

    public void setStatus(DeviceStatus status) {
        this.status = status;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum;
    }

    public String getPartNum() {
        return partNum;
    }

    public void setPartNum(String partNum) {
        this.partNum = partNum;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuSocket() {
        return cpuSocket;
    }

    public void setCpuSocket(String cpuSocket) {
        this.cpuSocket = cpuSocket;
    }

    public PersonalComputerDomain getDomain() {
        return domain;
    }

    public void setDomain(PersonalComputerDomain domain) {
        this.domain = domain;
    }

    public CaseType getCaseType() {
        return caseType;
    }

    public void setCaseType(CaseType caseType) {
        this.caseType = caseType;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPublicid() {
        return publicid;
    }

    public void setPublicid(String publicid) {
        this.publicid = publicid;
    }
}
