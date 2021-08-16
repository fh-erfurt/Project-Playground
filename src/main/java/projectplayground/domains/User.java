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

    private String username;
    private String password;
    private String email;

    private String firstName;
    private String lastName;
    @Transient
    private String message;

    @Column
    private Accesslevel accessLevel;
    private int children;

    @OneToMany
    private List<Playground> playgroundFavorites;

    @OneToMany
    private List<User> friends;

    @OneToOne(optional = true)
    private Playground currentPlayground;

}



