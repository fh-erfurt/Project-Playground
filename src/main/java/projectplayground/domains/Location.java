package projectplayground.domains;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import java.util.UUID;

/**
 * identifies the playground location
 * it contains the adress and is expanded by the district
 * */

@Getter
@Setter
@Entity
public class Location extends BaseEntity {
    private String streetname;
    private int houseNumber;
    private int postCode;
    private String cityname;
    private String district;
}
