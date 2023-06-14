package bna.projet.Services;

import bna.projet.Repository.EquipeRepository;
import bna.projet.entities.Equipe;
import bna.projet.helper.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
public class ExcelService {
    @Autowired
    EquipeRepository repository;

    public ByteArrayInputStream load() {
        List<Equipe> equipes = repository.findAll();

        ByteArrayInputStream in = ExcelHelper.equipesToExcel(equipes);
        return in;
    }

}
