package bna.projet.Services;

import bna.projet.Repository.DetailsOperationRepository;
import bna.projet.entities.DetailsOperation;
import bna.projet.entities.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DetailsOperationService implements IDetailsOperationService{


    @Autowired
    DetailsOperationRepository detailsOperationRepository;
    @Override
    public DetailsOperation addDetailsOperation(DetailsOperation dOp) {
        return detailsOperationRepository.save(dOp);

    }
}
