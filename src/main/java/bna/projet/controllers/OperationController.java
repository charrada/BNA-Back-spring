package bna.projet.controllers;


import bna.projet.Repository.CreditRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.Repository.ReponseRepository;
import bna.projet.Services.EquipeServiceImpl;
import bna.projet.Services.OperationService;
import bna.projet.entities.Credit;
import bna.projet.entities.Etudiant;
import bna.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("operation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OperationController {

    @Autowired
    OperationService operationService;
    @Autowired
    OperationRepository operationRepository;

    @GetMapping("/")
    public List<Operation> findAllOperation() {
        return operationService.findAllOperation();
    }

    @GetMapping ("/{id}")
    public Optional<Operation> getOperationById(@PathVariable Long id){

        return operationRepository.findById(id);
    }




}
