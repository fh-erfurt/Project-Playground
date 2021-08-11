package projectplayground.domains;
import com.sun.istack.NotNull;
import lombok.*;
import projectplayground.domains.enums.Accesslevel;
import javax.persistence.*;
import java.util.List;
import java.util.UUID;
/**
 * this class is used to map the user
 * it contains also the accessLevel, playgoundFavorites and friends
 * shows the currently accessed playgound
 *
 **/

@Entity
@Getter
@Setter
public class User extends BaseEntity {

    @Column
    protected Accesslevel accessLevel;
    protected int children;

    @OneToMany
    protected List<Playground> playgroundFavorites;

    @OneToMany
    protected List<User> friends;

    @OneToOne(optional = true)
    protected Playground currentPlayground;


}
