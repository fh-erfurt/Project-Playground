package projectplayground.controller;

import lombok.*;
import projectplayground.domains.Account;
import projectplayground.repositories.account.AccountRepositoryImpl;
import projectplayground.utils.SessionUtils;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
@Getter
@Setter
public class LoginController {

    private String pwd;
    private String msg;
    private String user;
    @PersistenceContext
    private EntityManager entityManager;

    public String Login()
    {
        return "login";
    }

    public String ValidateUsernamePassword() {
        boolean valid = validateUsernameAndPassword(user, pwd);
        if (valid) {
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            return "playgroundIndex";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Falscher Benutzername oder Passwort",
                            "Bitte geben Sie einen richtigen Benutzernamen uns Passwort an."));
            return "login";
        }
    }


    public String Logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "login";
    }


    public Boolean validateUsernameAndPassword(String username, String password)
    {
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


}
