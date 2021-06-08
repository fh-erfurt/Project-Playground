package projectplayground.storages;
import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Playground;

public interface PlaygroundRepository extends JpaRepository<Playground,Long> {


}
