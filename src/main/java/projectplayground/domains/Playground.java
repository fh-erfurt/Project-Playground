package projectplayground.domains;

import projectplayground.domains.enums.Cleanliness;
import projectplayground.domains.enums.Status;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
    private Status status;
    private Cleanliness cleanliness;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Location location;
    private String information;
    private int counterChildren;
    private int capacityPlayground;

    @Transient
    private List<Device> device;

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


}
