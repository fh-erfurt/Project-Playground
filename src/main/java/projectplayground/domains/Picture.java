package projectplayground.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Picture extends BaseEntity {

    private byte[] pictureFiles;
    private String name;

    @ManyToOne
    private Playground playground;
}
