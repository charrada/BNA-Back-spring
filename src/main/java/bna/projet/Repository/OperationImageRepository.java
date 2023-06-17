package bna.projet.Repository;

import bna.projet.entities.Contrat;
import bna.projet.entities.Etudiant;
import bna.projet.entities.OperationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperationImageRepository extends JpaRepository<OperationImage, Long> {
    Optional<OperationImage> findByName(String name);



}

