package projectplayground.repositories.playground;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectplayground.domains.Playground;

@Repository
public interface PlaygroundRepository extends JpaRepository<Playground,Long>, PlaygroundRepositoryCustom {


}
