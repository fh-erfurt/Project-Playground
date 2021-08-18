package projectplayground.domains;


import lombok.*;
import projectplayground.domains.enums.DeviceStatus;
import projectplayground.domains.enums.EnumValue;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 * maps the devices and contains their name and status
 * */

@Getter
@Setter
@Entity
public class Device extends BaseEntity {
    private String title;
    public DeviceStatus deviceStatus;
    private String description;
    private int deviceCapacity;

    @ManyToOne
    private Playground playground;

    @Transient
    public String deviceStatusValue()
    {
        String deviceStatusValue = EnumValue.deviceStatusValue(this.deviceStatus);
        return deviceStatusValue;
    }

}
