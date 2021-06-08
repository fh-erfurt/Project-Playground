package projectplayground.storages;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Playground;
import projectplayground.domains.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
