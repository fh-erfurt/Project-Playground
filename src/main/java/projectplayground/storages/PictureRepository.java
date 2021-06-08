package projectplayground.storages;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Picture;
import projectplayground.domains.User;

public interface PictureRepository extends JpaRepository<Picture,Long> {
}
