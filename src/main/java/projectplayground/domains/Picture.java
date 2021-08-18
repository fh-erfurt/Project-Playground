package projectplayground.domains;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

/**
 * class to access the pictureFiles via database
 * */

@Entity
@Getter
@Setter
public class Picture extends BaseEntity {


    private String name;

    private String path;

    @ManyToOne
    private Playground playground;



}
