package projectplayground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
