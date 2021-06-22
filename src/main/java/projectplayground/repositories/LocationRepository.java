package projectplayground.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
