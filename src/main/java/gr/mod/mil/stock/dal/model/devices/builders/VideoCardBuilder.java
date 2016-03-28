package gr.mod.mil.stock.dal.model.devices.builders;

import gr.mod.mil.stock.dal.model.devices.DeviceStatus;
import gr.mod.mil.stock.dal.model.devices.VideoCard;
import gr.mod.mil.stock.dal.model.devices.VideoCardInterface;

public class VideoCardBuilder {
    private DeviceStatus status;
    private String position;
    private String modelName;
    private String serialNum;
    private String partNum;
    private VideoCardInterface videoif;
    private int capacity;

    public VideoCardBuilder setStatus(DeviceStatus status) {
        this.status = status;
        return this;
    }

    public VideoCardBuilder setPosition(String position) {
        this.position = position;
        return this;
    }

    public VideoCardBuilder setModelName(String modelName) {
        this.modelName = modelName;
        return this;
    }

    public VideoCardBuilder setSerialNum(String serialNum) {
        this.serialNum = serialNum;
        return this;
    }

    public VideoCardBuilder setPartNum(String partNum) {
        this.partNum = partNum;
        return this;
    }

    public VideoCardBuilder setVideoif(VideoCardInterface videoif) {
        this.videoif = videoif;
        return this;
    }

    public VideoCardBuilder setCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public VideoCard createVideoCard() {
        return new VideoCard(status, position, modelName, serialNum, partNum, videoif, capacity);
    }
}