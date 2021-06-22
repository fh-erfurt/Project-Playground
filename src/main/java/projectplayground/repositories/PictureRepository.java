package projectplayground.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Picture;

public interface PictureRepository extends JpaRepository<Picture,Long> {
}
