package bna.projet.Services;

import bna.projet.Repository.CreditRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.entities.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class OperationService implements IOperationService{

    @Autowired
    CreditRepository creditRepository;

    @Autowired
    OperationRepository operationRepository;



    @Override
    public List<Operation> findAllOperation() {
        log.info("Récuperation de tous les operations");

        return operationRepository.findAll();
    }

    @Override
    public Operation findOperationById(Long id) {
        return operationRepository.findById(id).orElse(new Operation());
    }

}
