package bna.projet.Repository;

import bna.projet.entities.AccountPDP;
import bna.projet.entities.OperationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountPDPRepository extends JpaRepository<AccountPDP, Long> {
    Optional<AccountPDP> findById(Long id);
    Optional<AccountPDP> findByUsername(String username);
}


