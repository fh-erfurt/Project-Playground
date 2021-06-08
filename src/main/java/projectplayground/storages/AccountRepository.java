package projectplayground.storages;

import org.springframework.data.jpa.repository.JpaRepository;
import projectplayground.domains.Account;
import projectplayground.domains.User;

public interface AccountRepository extends JpaRepository<Account,Long> {
}
