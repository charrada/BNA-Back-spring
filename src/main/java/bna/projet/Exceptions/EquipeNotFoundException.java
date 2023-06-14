package bna.projet.Exceptions;

public class EquipeNotFoundException extends   RuntimeException {

    public EquipeNotFoundException(Long id) {
        super("Equipe introuvable " + id);
    }

}
