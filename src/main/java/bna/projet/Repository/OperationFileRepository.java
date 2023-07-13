package bna.projet.Repository;

import bna.projet.entities.OperationFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OperationFileRepository extends JpaRepository<OperationFile, Long> {
    //Optional<OperationImage> findByName(String name);


    Optional<OperationFile> findByIdOperation(Long idOperation);
}

