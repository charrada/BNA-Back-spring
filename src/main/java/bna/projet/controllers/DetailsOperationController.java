package bna.projet.controllers;


import bna.projet.Services.DetailsOperationService;
import bna.projet.entities.DetailsOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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




