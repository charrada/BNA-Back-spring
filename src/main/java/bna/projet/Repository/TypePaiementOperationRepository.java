package bna.projet.Repository;

import bna.projet.entities.TypePaiementOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaiementOperationRepository extends JpaRepository<TypePaiementOperation, Long> {



}

