package bna.projet.controllers;

import bna.projet.Repository.EtudiantRepository;
import bna.projet.entities.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("Etudiant")

@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EtudiantController {
    @Autowired
    bna.projet.Services.EtudiantService EtudiantService;
    @Autowired
    bna.projet.Repository.EtudiantRepository repo;
    @Autowired
    EtudiantRepository EtudiantRepository;

    @GetMapping("/")
    public List<Etudiant> findEtudiantList(){
        return (List<Etudiant>) repo.findAll();
    }

    @GetMapping ("Etudiant/{id}")
    public Optional<Etudiant> getEtudiantById(@PathVariable Long id){

        return repo.findById(id);
    }


    @PostMapping ("/AddEtudiant")
    public Etudiant AddEtudiant(@RequestBody Etudiant Etudiant){

        EtudiantService.addEtudiant(Etudiant);
        return Etudiant;
    }

    @PutMapping("updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant Etudiant ){

        return EtudiantService.updateEtudiant(Etudiant);
    }
    @GetMapping("TestClass")
    public List<Etudiant> findAllByFunction(@RequestParam String u, @RequestParam String d){
        return repo.findAllBy(u,d);
    }
}
