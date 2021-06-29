package projectplayground.repositories.picture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectplayground.domains.Picture;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long>, PictureRepositoryCustom {
}
