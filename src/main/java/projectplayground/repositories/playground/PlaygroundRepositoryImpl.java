package projectplayground.repositories.playground;

import org.springframework.stereotype.Repository;
import projectplayground.domains.Device;
import projectplayground.domains.Expansion;
import projectplayground.domains.Picture;
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

    public List<Device> findAllDevicesByPlaygroundID(long ID)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Device> query = builder.createQuery(Device.class);
        final Root<Device> device = query.from(Device.class);
        Predicate idCondition = builder.equal(device.join("playground").get("id"), ID);
        final CriteriaQuery<Device> findDevice = query.where(idCondition);

        List<Device> result = entityManager.createQuery(findDevice).getResultList();

        if(result != null)
            return result;
        return null;
    }

    public List<Expansion> findAllExpansionsByPlaygroundID(long ID)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Expansion> query = builder.createQuery(Expansion.class);
        final Root<Expansion> expansion = query.from(Expansion.class);
        Predicate idCondition = builder.equal(expansion.join("playground").get("id"), ID);
        final CriteriaQuery<Expansion> findExpansion = query.where(idCondition);

        List<Expansion> result = entityManager.createQuery(findExpansion).getResultList();

        if(result != null)
            return result;
        return null;
    }

}
