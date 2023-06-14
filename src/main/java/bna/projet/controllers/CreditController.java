package bna.projet.controllers;


import bna.projet.Services.CreditService;
import bna.projet.entities.Credit;
import bna.projet.entities.Departement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("credit")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CreditController {

    @Autowired
    CreditService creditService;





    @PostMapping("/addCredit")
    public Credit addCredit(@RequestBody Credit c){

        creditService.addCredit(c);
        return c;
    }


    @GetMapping("/")
    public List<Credit> findAllCredit() {
        return creditService.findAllCredit();
    }








}
