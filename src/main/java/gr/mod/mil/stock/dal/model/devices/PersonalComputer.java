package gr.mod.mil.stock.dal.model.devices;

import gr.mod.mil.stock.dal.model.barcode.BarcodePrintable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

// edw orizoume me to @entity to table stin database me onoma PersonalComputer
// me ta onomata ton collums tou
@Entity
public class PersonalComputer extends Device implements BarcodePrintable{

    @Enumerated(EnumType.STRING)
    private PersonalComputerDomain domain;
    public PersonalComputerDomain getDomain() { return domain; }
    public void setDomain(PersonalComputerDomain domain) { this.domain = domain; }

    @Enumerated(EnumType.STRING)
    private CaseType caseType;
    public CaseType getCaseType() { return caseType; }
    public void setCaseType(CaseType caseType) { this.caseType = caseType; }

    private int ram; // in MB
    public int getRam() { return ram; }
    public void setRam(int ram) { this.ram = ram; }

    private long belongs_to;

    public long getBelongs_to() {
        return belongs_to;
    }

    public void setBelongs_to(long belongs_to) {
        this.belongs_to = belongs_to;
    }

    private int memory; // in GB
    public int getMemory() { return memory; }
    public void setMemory(int memory) { this.memory = memory; }

    private String cpu;
    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    private String cpuSocket;
    public String getCpuSocket() { return  cpuSocket; }
    public void setCpuSocket(String cpuSocket) { this.cpuSocket = cpuSocket; }

    public PersonalComputer(DeviceStatus status, String position, String modelName, String serialNum, String partNum, String publicid, PersonalComputerDomain domain, CaseType caseType, int ram, int memory, String cpu, String cpuSocket,long belongs_to) {
        super(status, position, modelName, serialNum, partNum, publicid);
        this.domain = domain;
        this.caseType = caseType;
        this.ram = ram;
        this.memory = memory;
        this.cpu = cpu;
        this.cpuSocket = cpuSocket;
        this.belongs_to=belongs_to;
    }

    public PersonalComputer() {}

    @Override
    public String getBarcodeText() {
        return this.getPublicid();
    }

    @Override
    public String getPrintableText() {
        return this.getModelName();
    }
}
