package bna.projet.BatchProjet;
import bna.projet.entities.Etat;
import bna.projet.entities.Projet;
import bna.projet.entities.Tache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;

@Slf4j
public class ProjectProcessorProjet implements ItemProcessor<Projet, Projet> {
    @Override
public Projet process(Projet p) {
    log.info("Start Batch Item Processor");
    for (Tache t: p.getTaches() ) {
        t.setEtatTache(Etat.DONE);
    }
    return p;
}
}
