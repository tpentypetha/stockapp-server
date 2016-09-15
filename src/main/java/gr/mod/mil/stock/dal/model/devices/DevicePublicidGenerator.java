package gr.mod.mil.stock.dal.model.devices;

import java.util.UUID;

public class DevicePublicidGenerator {

    public void generate(Device device) {
        // dimiourgia tou publicid sta DEVICES
        String id = device.getModelName().trim().replaceAll("\\s","").substring(0,5)+  // pernoume ta prota 5 grammata tou model name
                UUID.randomUUID().toString().replace('-',' ').trim().substring(0,9); /// kai ta 9 prota grammata tou randomUUID
        device.setPublicid(id.trim());
    }

}
