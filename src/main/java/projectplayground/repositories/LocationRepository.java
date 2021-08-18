package projectplayground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectplayground.domains.Location;
import projectplayground.domains.User;
import projectplayground.repositories.user.UserRepositoryCustom;

@Repository
public interface LocationRepository extends JpaRepository<Location,Long> {

}