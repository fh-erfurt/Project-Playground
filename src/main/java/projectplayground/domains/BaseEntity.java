package projectplayground.domains;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.UUID;

/**
 * the BaseEntity class
 * */

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO) //ID is generated
    private Long id;
}
