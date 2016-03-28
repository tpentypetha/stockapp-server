package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.Memory;
import gr.mod.mil.stock.dal.model.devices.MemorySocket;

public class MemoryBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private MemorySocket socket;
    private int capacity;

    public MemoryBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public MemoryBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public MemoryBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public MemoryBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public MemoryBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public MemoryBuilder setSocket(MemorySocket socket) {
        this.socket = socket;
        return this;
    }

    public MemoryBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public Memory createMemory() {
        return new Memory(status, position, modelName, serialNum, partNum, socket, capacity);
    }
}