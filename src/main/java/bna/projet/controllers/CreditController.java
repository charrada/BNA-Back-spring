package bna.projet.controllers;


import bna.projet.Repository.CreditRepository;
import bna.projet.Services.CreditService;
import bna.projet.entities.Credit;
import bna.projet.entities.Debiteur;
import bna.projet.entities.Departement;
import bna.projet.entities.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditController {

    @Autowired
    CreditService creditService;

    @Autowired
    CreditRepository creditRepository;



    @PutMapping("addMontant/{id}/{m}")
    public Credit addMontantCredit(@PathVariable Long id, @PathVariable long m,@RequestBody Credit c) {
        // Vérifier si l'opération existe
        c = creditService.findCreditById(id);
        c.setMontant(m+c.getMontant());
        return creditRepository.save(c);
    }


    @PutMapping("reduceMontant/{id}/{m}")
    public Credit reduceMontantCredit(@PathVariable Long id, @PathVariable long m,@RequestBody Credit c) {
        // Vérifier si l'opération existe
        c = creditService.findCreditById(id);
        c.setMontant(c.getMontant()-m);
        return creditRepository.save(c);
    }




    @PostMapping("/addCredit")
    public Credit addCredit(@RequestBody Credit c){

        creditService.addCredit(c);
        return c;
    }


    @GetMapping("/")
    public List<Credit> findAllCredit() {
        return creditService.findAllCredit();
    }



    @GetMapping("/{debiteurId}")
    public List<Credit> getCreditByDebiteurId(@PathVariable Long debiteurId) {
        Debiteur debiteur = new Debiteur();
        debiteur.setId_deb(debiteurId);

        return creditRepository.findByDebiteur(debiteur);
    }







}
