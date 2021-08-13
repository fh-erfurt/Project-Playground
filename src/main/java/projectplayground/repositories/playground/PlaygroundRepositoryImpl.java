package projectplayground.repositories.playground;

import org.springframework.stereotype.Repository;
import projectplayground.domains.Playground;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Locale;

@Repository
public class PlaygroundRepositoryImpl
{
    @PersistenceContext
    private EntityManager entityManager;


    public List<Playground> findAllPlaygrounds(String playgroundName, String streetName)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Playground> query = builder.createQuery(Playground.class);
        final Root<Playground> playground = query.from(Playground.class);
        Predicate name = builder.like(builder.upper(playground.get("title")), "%" + playgroundName.toUpperCase() + "%");
        Predicate streetname = builder.like(builder.upper(playground.join("location").get("streetname")), "%" + streetName.toUpperCase() + "%");

        final CriteriaQuery<Playground>    findPlayground = query.where(name, streetname);

        List<Playground> result = entityManager.createQuery(findPlayground).getResultList();

        if(result != null)
            return result;
        return null;
    }

}
