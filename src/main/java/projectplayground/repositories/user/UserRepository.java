package projectplayground.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectplayground.domains.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>, UserRepositoryCustom {

}
