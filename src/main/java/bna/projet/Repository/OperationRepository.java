package bna.projet.Repository;


import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {

    List<Operation> findByTypeOperation(String typeOperation);

    List<Operation> findByEtatOperationAndTypeOperation(String etatOperation, String typeOperation);

    List<Operation> findByCredit(Credit credit);

    long countByTypeOperationAndVu(String typeOperation, int vu);
}
