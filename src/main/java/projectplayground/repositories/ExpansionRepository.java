package projectplayground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Expansion;

public interface ExpansionRepository extends JpaRepository<Expansion,Long> {
}
