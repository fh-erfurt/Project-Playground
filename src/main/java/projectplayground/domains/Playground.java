package projectplayground.domains;

import projectplayground.domains.enums.Cleanliness;
import projectplayground.domains.enums.EnumValue;
import projectplayground.domains.enums.Status;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.List;

/**
 * is the basic class to map a playground
 * is used as the data base for the user acces
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Playground extends BaseEntity {

    private String title;
    private Cleanliness cleanliness;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location location;

    @Column(columnDefinition = "VARCHAR(1024)")
    private String information;
    private int counterChildren;
    private int capacityPlayground;


    public String statusValue()
    {

        double percentageChildren = this.counterChildren / (double) this.capacityPlayground * 100;
        if (percentageChildren < 40) // bis 40%
        {
            return EnumValue.statusValue(Status.open);
        }
        else if (percentageChildren < 90) // bis 90%
        {
            return EnumValue.statusValue(Status.wellVisited);
        }
        else if (percentageChildren <= 100) // bis 100%
        {
            return EnumValue.statusValue(Status.full);
        }
        else // > 100%
        {
            return EnumValue.statusValue(Status.overfilled);
        }
    }

    public String cleanlinessValue()
    {
        String cleanlinessValue = EnumValue.cleanlinessLevelValue(this.cleanliness);
        return cleanlinessValue;
    }

    @Transient
    private List<Device> devices;

    @Transient
    private List<Expansion> expansions;

    @Transient
    private List<Picture> pictures;

    @OneToMany
    private List<User> registeredUsers;



    public void addPicture(Picture picture)
    {
        if(picture != null)
            this.pictures.add(picture);

    }
    public void addDevice(Device device)
    {
        if(device != null)
            this.devices.add(device);

    }

    public void addExpansion(Expansion expansion)
    {
        if(expansion != null)
            this.expansions.add(expansion);

    }


}
