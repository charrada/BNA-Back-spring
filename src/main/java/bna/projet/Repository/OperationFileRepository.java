package bna.projet.Repository;

import bna.projet.entities.OperationImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationFileRepository extends JpaRepository<OperationImage, Long> {
    //Optional<OperationImage> findByName(String name);


    Optional<OperationImage> findByIdOperation(Long idOperation);
}

