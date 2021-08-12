package projectplayground.repositories.account;

import org.apache.commons.lang3.reflect.Typed;
import org.springframework.stereotype.Repository;
import projectplayground.domains.Account;
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
public class AccountRepositoryImpl implements AccountRepositoryCustom
{
    @PersistenceContext
    private EntityManager entityManager;


    public Boolean validateUsernameAndPassword(String username, String password)
    {
//        entityManager.createQuery;
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Account> query = builder.createQuery(Account.class);
        final Root<Account> account = query.from(Account.class);


        Predicate userNameCondition = builder.equal(account.get("username"), username);
        Predicate passwordCondition = builder.equal(account.get("password"), password);
        List<Predicate> predicates = new ArrayList<Predicate>();
        predicates.add(userNameCondition);
        predicates.add(passwordCondition);
        final CriteriaQuery<Account> findUser = query.where(predicates.toArray(new Predicate[]{}));

        TypedQuery<Account> result = entityManager.createQuery(findUser);

        if(result != null)
            return true;
        return false;
    }

    public Account findAccountByName(String accountName)
    {
        final CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        final CriteriaQuery<Account> query = builder.createQuery(Account.class);
        final Root<Account> account = query.from(Account.class);
        Predicate nameCondition = builder.equal(account.get("username"), accountName);
        final CriteriaQuery<Account> findAccount = query.where(nameCondition);

        Account result = entityManager.createQuery(findAccount).getSingleResult();

        if(result != null)
            return result;
        else
            return null;
    }
}
