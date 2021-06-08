package projectplayground.storages;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Expansion;
import projectplayground.domains.User;

public interface ExpansionRepository extends JpaRepository<Expansion,Long> {
}
