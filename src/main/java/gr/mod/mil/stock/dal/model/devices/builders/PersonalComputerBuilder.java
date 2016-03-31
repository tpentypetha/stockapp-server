package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.*;

public class PersonalComputerBuilder {

    private final DevicePublicidGenerator generator = new DevicePublicidGenerator();

    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private String publicid;
    private PersonalComputerDomain domain;
    private CaseType caseType;
    private int ram;
    private int memory;
    private String cpu;
    private String cpuSocket;

    public PersonalComputerBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public PersonalComputerBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public PersonalComputerBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public PersonalComputerBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public PersonalComputerBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public PersonalComputerBuilder setPublicid(String publicid) {
        this.publicid = publicid;
        return this;
    }

    public PersonalComputerBuilder setDomain(PersonalComputerDomain domain) {
        this.domain = domain;
        return this;
    }

    public PersonalComputerBuilder setCaseType(CaseType caseType) {
        this.caseType = caseType;
        return this;
    }

    public PersonalComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PersonalComputerBuilder setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    public PersonalComputerBuilder setCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    public PersonalComputerBuilder setCpuSocket(String cpuSocket) {
        this.cpuSocket = cpuSocket;
        return this;
    }

    public PersonalComputer createPersonalComputer() {
        PersonalComputer created = new PersonalComputer(status, position, modelName, serialNum, partNum, publicid, domain, caseType, ram, memory, cpu, cpuSocket);
        generator.generate(created);
        return created;
    }
}