package bna.projet.Repository;


import bna.projet.entities.Account;
import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


    Account findByUsername(String username);
}
