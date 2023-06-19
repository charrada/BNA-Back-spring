package bna.projet.Repository;

import bna.projet.entities.Contrat;
import bna.projet.entities.Etudiant;
import bna.projet.entities.TypePaiementOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypePaiementOperationRepository extends JpaRepository<TypePaiementOperation, Long> {



}

