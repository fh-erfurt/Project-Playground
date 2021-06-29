package projectplayground.repositories.picture;

import org.springframework.stereotype.Repository;
import projectplayground.domains.Picture;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PictureRepositoryImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Picture> findAllPicturesByPlaygroundId(long id) {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Picture> query = builder.createQuery(Picture.class);
        final Root<Picture> picture = query.from(Picture.class);
        Predicate idCondition = builder.equal(picture.join("playground").get("id"), id);
        final CriteriaQuery<Picture> findPicture = query.where(idCondition);

        List<Picture> result = entityManager.createQuery(findPicture).getResultList();

        if(result != null)
            return result;
        return null;
    }


}
