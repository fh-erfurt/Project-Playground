package projectplayground.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
public class Location extends BaseEntity {

    private String streetname;
    private int houseNumber;
    private int postCode;
    private String cityname;
    private String district;
}
