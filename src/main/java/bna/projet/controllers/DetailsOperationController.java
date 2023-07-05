package bna.projet.controllers;


import bna.projet.Repository.OperationRepository;
import bna.projet.Services.DetailsOperationService;
import bna.projet.Services.EquipeServiceImpl;
import bna.projet.Services.OperationService;
import bna.projet.entities.Credit;
import bna.projet.entities.DetailsOperation;
import bna.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dOperation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DetailsOperationController {

    @Autowired
    DetailsOperationService detailsOperationService;

    @PostMapping("/add")
    public DetailsOperation addDetailsOperation(@RequestBody DetailsOperation dOp) {


        // Ajouter l'opération en l'associant au crédit
        return detailsOperationService.addDetailsOperation(dOp);
    }

}




