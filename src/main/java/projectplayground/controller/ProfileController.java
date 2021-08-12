package projectplayground.controller;



import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import projectplayground.domains.Account;
import projectplayground.repositories.account.AccountRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ManagedBean
@RequestScoped
@Getter
@Setter
public class ProfileController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private AccountRepository accountRepository;

    public Account account;

    public String Index()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account findAccount = accountRepository.findAccountByName(authentication.getName());
        this.account = findAccount;

        return "profileIndex";
    }
}
