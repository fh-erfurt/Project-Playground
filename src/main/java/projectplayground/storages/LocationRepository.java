package projectplayground.storages;
import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Location;
import projectplayground.domains.Playground;

public interface LocationRepository extends JpaRepository<Location,Long> {

}
