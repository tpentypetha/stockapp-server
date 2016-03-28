package gr.mod.mil.stock.dal.model.devices;

import org.springframework.stereotype.Component;

import java.util.UUID;

public class DevicePublicidGenerator {

    public void generate(Device device) {
        device.setPublicid(device.getModelName().substring(0,5)+ UUID.randomUUID().toString().substring(0,9));
    }

}
