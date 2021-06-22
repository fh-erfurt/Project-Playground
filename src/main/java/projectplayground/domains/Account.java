package projectplayground.domains;
import lombok.Getter;
import lombok.Setter;
import projectplayground.repositories.account.AccountRepositoryImpl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

    private String username;
    private String password;
    private String email;

    @OneToOne
    private User user;

}
