package gr.mod.mil.stock.dal.model.devices;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class VideoCard extends Device {

    @Enumerated(EnumType.STRING)
    private VideoCardInterface videoif;
    public VideoCardInterface getVideoif() { return videoif; }
    public void setVideoif(VideoCardInterface videoif) { this.videoif = videoif; }

    private int capacity;
    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public VideoCard(DeviceStatus status, String position, String modelName, String serialNum, String partNum, VideoCardInterface videoif, int capacity) {
        super(status, position, modelName, serialNum, partNum);
        this.videoif = videoif;
        this.capacity = capacity;
    }
}
