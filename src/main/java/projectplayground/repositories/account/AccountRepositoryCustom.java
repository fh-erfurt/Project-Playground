package projectplayground.repositories.account;

import projectplayground.domains.Account;

public interface AccountRepositoryCustom {

    Boolean validateUsernameAndPassword(String username, String password);
    Account findAccountByName(String accountName);
}
