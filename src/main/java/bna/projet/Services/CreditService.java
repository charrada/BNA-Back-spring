package bna.projet.Services;


import bna.projet.Repository.CreditRepository;
import bna.projet.entities.Credit;
import bna.projet.entities.Departement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CreditService implements ICreditService {


    @Autowired
    CreditRepository creditRepository;



    @Override
    public Credit addCredit(Credit c) {
        return creditRepository.save(c);
    }


    @Override
    public List<Credit> findAllCredit() {
        log.info("Récuperation de tous les credits");

        return creditRepository.findAll();
    }

}
