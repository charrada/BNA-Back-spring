package bna.projet.controllers;


import bna.projet.Repository.AuxiliaireOperationRepository;
import bna.projet.Repository.DebiteurRepository;
import bna.projet.Repository.DetailsOperationRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.Services.DetailsOperationService;
import bna.projet.Services.OperationService;
import bna.projet.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("deb")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DebiteurController {

    @Autowired
  DebiteurRepository debiteurRepository;

    @GetMapping("/{id}")
    public Debiteur getDebiteurById(@PathVariable Long id) {
        return debiteurRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Auxiliaire operation not found with id: " + id));
    }


}




