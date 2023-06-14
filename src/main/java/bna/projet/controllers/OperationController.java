package bna.projet.controllers;


import bna.projet.Repository.CreditRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.Repository.ReponseRepository;
import bna.projet.Services.EquipeServiceImpl;
import bna.projet.Services.OperationService;
import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("operation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OperationController {

    @Autowired
    OperationService operationService;



    @GetMapping("/")
    public List<Operation> findAllOperation() {
        return operationService.findAllOperation();
    }

    @PostMapping("/addOperation/{creditId}")
    public Operation addOperation(@PathVariable Long creditId, @RequestBody Operation operation) {
        return operationService.addOperation(creditId, operation);
    }



    @GetMapping("/credit/{creditId}")
    public List<Operation> getOperationsByCredit(@PathVariable Long creditId) {
        return operationService.getOperationsByCredit(creditId);
    }

}
