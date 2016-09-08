package gr.mod.mil.stock.services;

import gr.mod.mil.stock.dal.model.devices.KeyboardVideoMouse;
import gr.mod.mil.stock.dal.repos.KvmRepository;
import gr.mod.mil.stock.web.dto.kvm.addKvmDeviceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AddKvmService  {


    @Autowired
    KvmRepository Kvms;

    public KeyboardVideoMouse addKvm(addKvmDeviceDto data) {
        List<KeyboardVideoMouse> found = Kvms.findByName(data.getModelName());
        if (found.isEmpty()) {
            KeyboardVideoMouse kvm = new KeyboardVideoMouse();
            kvm.setModel_name(data.getModelName().trim());
            kvm.setPUBLICID(UUID.randomUUID().toString().trim());
            kvm.setStatus(data.getStatus());
            kvm.setNUM_DEVICES_SUPPORTED(Integer.valueOf(data.getNumofdevices()));
            return Kvms.save(kvm);
        } else {
            return null;
        }

    }






}
