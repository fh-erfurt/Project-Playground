package projectplayground.domains;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 * is the basic class for every additional expansions of the playground
 */

@Getter
@Setter
@Entity
public class Expansion extends BaseEntity {
    private String title;
    private int numberOfPersons;
    private String description;

    @ManyToOne
    private Playground playground;
}
