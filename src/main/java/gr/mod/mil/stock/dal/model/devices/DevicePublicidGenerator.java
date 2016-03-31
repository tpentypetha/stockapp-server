package gr.mod.mil.stock.dal.model.devices;

import java.util.UUID;

public class DevicePublicidGenerator {

    public void generate(Device device) {
        String id = device.getModelName().trim().replaceAll("\\s","").substring(0,5)+
                UUID.randomUUID().toString().replace('-',' ').trim().substring(0,9);
        device.setPublicid(id.trim());
    }

}
