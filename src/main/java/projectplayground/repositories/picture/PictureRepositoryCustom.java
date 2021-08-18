package projectplayground.repositories.picture;

import projectplayground.domains.Device;
import projectplayground.domains.Picture;

import java.util.List;

public interface PictureRepositoryCustom {

    List<Picture> findAllPicturesByPlaygroundId(long id);
}
