package bna.projet.Repository;


import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import bna.projet.entities.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation,Long> {


    List<Operation> findByCredit(Credit credit);
}
