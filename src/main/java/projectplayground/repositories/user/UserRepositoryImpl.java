package projectplayground.repositories.user;

import org.springframework.stereotype.Repository;
import projectplayground.domains.Friend;
import projectplayground.domains.Picture;
import projectplayground.domains.Playground;
import projectplayground.domains.User;
import projectplayground.repositories.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom
{
    @PersistenceContext
    private EntityManager entityManager;


    public User findUserByUsername(String userName)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root<User> user = query.from(User.class);
        Predicate nameCondition = builder.equal(user.get("username"), userName);
        final CriteriaQuery<User> findAccount = query.where(nameCondition);

        User result = entityManager.createQuery(findAccount).getSingleResult();

        if(result != null)
            return result;
        else
            return null;
    }

    public List<User> findUsersByName(String firstName, String lastName)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<User> query = builder.createQuery(User.class);
        final Root<User> user = query.from(User.class);
        Predicate firstNameCondition = builder.like(builder.upper(user.get("firstName")), "%" + firstName.toUpperCase() + "%");

        Predicate lastNameCondition = builder.like(builder.upper(user.get("lastName")), "%" + lastName.toUpperCase() + "%");


        final CriteriaQuery<User> findAccount = query.where(firstNameCondition, lastNameCondition);

        List<User> resultList = entityManager.createQuery(findAccount).getResultList();

        if(resultList != null)
            return resultList;
        else
            return null;
    }

    @Transactional
    public void addFriend(User currentUser, User newFriend)
    {
            entityManager.createNativeQuery("INSERT INTO USER_FRIENDS (USER_ID, FRIENDS_ID)"
                            + " VALUES ( :a, :b)")
                    .setParameter("a", currentUser.getId())
                    .setParameter("b", newFriend.getId()).executeUpdate();

    }

    @Transactional
    public void removeFriend(User currentUser, User toBeDeletedFriend)
    {
        entityManager.createNativeQuery("DELETE FROM USER_FRIENDS WHERE USER_ID = :a AND FRIENDS_ID = :b")
                .setParameter("a", currentUser.getId())
                .setParameter("b", toBeDeletedFriend.getId()).executeUpdate();
    }

    @Transactional
    public void loginUserToPlayground(User user, Playground playground)
    {
        user.setCurrentPlayground(playground);
        entityManager.merge(user);
    }

    @Transactional
    public void logoutUserFromPlayground(User user)
    {
        user.setCurrentPlayground(null);
        entityManager.merge(user);
    }

    public List<Long> findAllFriends(User currentUser)
    {

        List<Long> result =  entityManager.createNativeQuery("SELECT FRIENDS_ID FROM USER_FRIENDS WHERE USER_ID = :a")
                .setParameter("a", currentUser.getId()).getResultList();
        if(result != null)
            return result;
        return null;
    }
}
