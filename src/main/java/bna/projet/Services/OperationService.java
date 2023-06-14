package bna.projet.Services;

import bna.projet.Repository.CreditRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.entities.Credit;
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
    public Operation addOperation(Long creditId, Operation operation) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credit ID"));

        operation.setCredit(credit);
        operationRepository.save(operation);

        return operation;
    }


    @Override
    public List<Operation> findAllOperation() {
        log.info("Récuperation de tous les operations");

        return operationRepository.findAll();
    }


    @Override

    public List<Operation> getOperationsByCredit(Long creditId) {
        Credit credit = creditRepository.findById(creditId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid credit ID"));

        return credit.getOperationList();
    }

}
