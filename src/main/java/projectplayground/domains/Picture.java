package projectplayground.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Picture extends BaseEntity {


    private String name;

    private String path;

    @ManyToOne
    private Playground playground;



}
