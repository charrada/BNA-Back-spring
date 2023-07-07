package bna.projet.controllers;


import bna.projet.Repository.AuxiliaireOperationRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.Services.OperationService;
import bna.projet.entities.AuxiliaireOperation;
import bna.projet.entities.Credit;
import bna.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("aux")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AuxiliaireOperationController {

    @Autowired
    OperationService operationService;
    @Autowired
    AuxiliaireOperationRepository auxiliaireOperationRepository;


    @GetMapping("/type/{type}")
    public List<AuxiliaireOperation> getByType(@PathVariable String type) {
        return auxiliaireOperationRepository.findByTypeAux(type);
    }
    @GetMapping("/{id}")
    public AuxiliaireOperation getAuxiliaireOperationById(@PathVariable Long id) {
        return auxiliaireOperationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Auxiliaire operation not found with id: " + id));
    }


}




