package bna.projet.Services;

import bna.projet.Repository.DetailEquipeRepository;
import bna.projet.entities.DetailEquipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailEquipeServiceImpl implements DetailEquipeService {
    @Autowired //ou @Inject
    DetailEquipeRepository dr;
    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe d) {
        return  dr.save(d);
    }

    @Override
    public List<DetailEquipe> addDetailEquipe(List<DetailEquipe> listDetailEquipe) {
        return dr.saveAll(listDetailEquipe);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe d) {
        return dr.save(d);
    }

    @Override
    public List<DetailEquipe> updateDetailEquipe(List<DetailEquipe> listDetailEquipe) {
        return dr.saveAll(listDetailEquipe);
    }

    @Override
    public void deleteDetailEquipe(Long id) {
        dr.deleteById(id);
    }

    @Override
    public void deleteDetailEquipe(DetailEquipe d) {
        dr.delete(d);
    }

    @Override
    public List<DetailEquipe> findAllDetailEquipe() {
        return dr.findAll();
    }

    @Override
    public DetailEquipe findDetailEquipeById(Long id) {
        return dr.findById(id).orElse(new DetailEquipe());
    }
}
