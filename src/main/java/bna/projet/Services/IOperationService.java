package bna.projet.Services;

import bna.projet.entities.Operation;

import java.util.List;

public interface IOperationService {
   // Operation addOperation(Long creditId, Operation operation);


    List<Operation> findAllOperation();

    Operation findOperationById(Long id);

    Operation addOperation(Operation operation);
}
