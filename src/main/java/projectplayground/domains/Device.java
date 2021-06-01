package projectplayground.domains;


import lombok.*;
import projectplayground.domains.enums.DeviceStatus;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * maps the devices and contains their name and status
 * */

@Getter
@Setter
@Entity
public class Device extends BaseEntity {
    private String title;
    private DeviceStatus deviceStatus;
    private String description;
    private int deviceCapacity;

    @ManyToOne
    private Playground playground;
}
