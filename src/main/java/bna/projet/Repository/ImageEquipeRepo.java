package bna.projet.Repository;

import bna.projet.entities.ImageEquipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ImageEquipeRepo extends CrudRepository<ImageEquipe,Long> {
    Optional<ImageEquipe> findByName(String name);
}
