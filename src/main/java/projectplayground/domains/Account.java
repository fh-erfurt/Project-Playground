package projectplayground.domains;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;


/**
 * Account is the class for the user
 * it contains username, password and email
 * the user himself and the roles and rights can be identified with the associated userID
 * */
@Getter
@Setter
@Entity
public class Account extends BaseEntity {
//    @Id
//    @GeneratedValue
//    private UUID ID;
    private String username;
    private String password;
    private String email;
    private UUID userID;
}
