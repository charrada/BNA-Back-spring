package bna.projet.controllers;

import bna.projet.Services.TypePaiementOperationService;
import bna.projet.entities.TypePaiementOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("TypeP")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TypePaiementOperationController {

    @Autowired
    private TypePaiementOperationService typePaiementOperationService;

    @GetMapping("/")
    public List<TypePaiementOperation> findAllTypePaiementOperation() {
        return typePaiementOperationService.findAllTypePaiementOperation();
    }


}
