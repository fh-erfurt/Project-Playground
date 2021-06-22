package projectplayground.repositories.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectplayground.domains.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long>, AccountRepositoryCustom {

}
