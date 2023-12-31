package bna.projet.Services;

import bna.projet.entities.DetailEquipe;
import bna.projet.entities.Equipe;
import bna.projet.entities.EquipeResponse;
import bna.projet.entities.Etudiant;

import java.io.IOException;
import java.util.List;

public interface EquipeService {

    Equipe saveEquipe (Equipe equipe) throws IOException;
    void saveEquipeAndDetail(Equipe equipe, DetailEquipe detailEquipe);


    Equipe updateEquipe (Equipe equipe,Long idE);
    void deleteEquipe (Equipe equipe);
    void deleteEquipeById (Long id);
    List<Equipe> findEquipes();
    Equipe findById(Long id) ;

    Boolean isValid(Equipe e,Long id);
    Boolean changeIsValid(Equipe e);
    void faireEvoluerEquipes();
     void ajouterMembreEquipe(Long idEq, Long idEt);
    void MembreToResponsableEquipe(Long idEt,Long idEquipe);
    void affecterImageToEquipe(Long idE,Long idIm);
    EquipeResponse getAllEquipes(int pageNo, int pageSize, String sortBy, String sortDir);
    void supprimerEtudiantFromEquipe(Long idEt,Long idEquipe);
    List<Etudiant> getMembers(Long id);
    Etudiant deleteEtudiantFromEquipe(Long idEtudiant);
    Etudiant ValiderEtudiant(Long idEtudiant);

}
