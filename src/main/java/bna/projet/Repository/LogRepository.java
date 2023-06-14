package bna.projet.Repository;

import bna.projet.entities.Log;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LogRepository extends CrudRepository<Log,Integer> {



}
