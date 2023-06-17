package bna.projet.Repository;

import bna.projet.entities.Credit;
import bna.projet.entities.Debiteur;
import bna.projet.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {

    List<Credit> findByDebiteur(Debiteur debiteur);
}
