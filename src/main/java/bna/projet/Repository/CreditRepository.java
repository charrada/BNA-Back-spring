package bna.projet.Repository;

import bna.projet.entities.Credit;
import bna.projet.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CreditRepository extends JpaRepository<Credit,Long> {

}
