package bna.projet.Repository;


import bna.projet.entities.AuxiliaireOperation;
import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuxiliaireOperationRepository extends JpaRepository<AuxiliaireOperation, Long> {

    List<AuxiliaireOperation> findByTypeAux(String type);

}

