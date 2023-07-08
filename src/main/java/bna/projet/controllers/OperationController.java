package bna.projet.controllers;


import bna.projet.Repository.CreditRepository;
import bna.projet.Repository.DetailsOperationRepository;
import bna.projet.Repository.OperationRepository;
import bna.projet.Repository.ReponseRepository;
import bna.projet.Services.DetailsOperationService;
import bna.projet.Services.EquipeServiceImpl;
import bna.projet.Services.OperationService;
import bna.projet.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @Autowired
    DetailsOperationRepository detailsOperationRepository;

    @Autowired
    DetailsOperationService detailsOperationService;
    @GetMapping("/")
    public List<Operation> findAllOperation() {
        return operationService.findAllOperation();
    }

    @GetMapping("credit/{creditId}")
    public List<Operation> getOperationsByCreditId(@PathVariable Long creditId) {
        Credit credit = new Credit();
        credit.setIdCredit(creditId);

        return operationRepository.findByCredit(credit);
    }



    @GetMapping("admin/{typeOperation}/{etatOperation}")
    public List<Operation> getOperationsByEtatAndType( @PathVariable String typeOperation,
                                                       @PathVariable String etatOperation

    ) {
        return operationRepository.findByEtatOperationAndTypeOperation(etatOperation, typeOperation);
    }



    @PutMapping("changeEtat/{id}/{etat}")
    public Operation updateOperation(@PathVariable Long id, @PathVariable String etat,@RequestBody Operation op) {
        // Vérifier si l'opération existe
         op = operationService.findOperationById(id);
        op.setEtatOperation(etat);
        return operationRepository.save(op);
    }




    @PostMapping("/add")
    public Operation addOperation(@RequestBody Operation operation) {
        // Vérifier si le crédit associé à l'opération existe
        Credit credit = operation.getCredit();
        if (credit == null || credit.getIdCredit() == null) {
            throw new IllegalArgumentException("Credit is required for the operation");
        }

        DetailsOperation detailsOperation = new DetailsOperation();
        // Set the necessary details for the detailsOperation object
        detailsOperation.setTypeDetails(operation.getDetailsOperation().getTypeDetails());
        detailsOperation.setNumPieceEnregistrement(operation.getDetailsOperation().getNumPieceEnregistrement());
        detailsOperation.setTypePieceEnregistrement(operation.getDetailsOperation().getTypePieceEnregistrement());
        detailsOperation.setTypeTimbrage(operation.getDetailsOperation().getTypeTimbrage());
        detailsOperation.setNumAffaireAuxiliaire(operation.getDetailsOperation().getNumAffaireAuxiliaire());
        detailsOperation.setIdAuxOperation(operation.getDetailsOperation().getIdAuxOperation());

        // Save the detailsOperation object first
        detailsOperationRepository.save(detailsOperation);

        operation.setDetailsOperation(detailsOperation); // Set the detailsOperation for the operation

        return operationService.addOperation(operation);
    }








/*
    @PostMapping("add")
    public Operation addOperation(@RequestBody Operation operation, @RequestParam("file") MultipartFile file) {
        // Vérifier si le crédit associé à l'opération existe
        Credit credit = operation.getCredit();
        if (credit == null || credit.getIdCredit() == null) {
            // Gérer l'erreur de crédit manquant
            // Vous pouvez lancer une exception ou retourner un message d'erreur approprié
            throw new IllegalArgumentException("Credit is required for the operation");
        }

        // Vérifier si un fichier image a été fourni
        if (file != null && !file.isEmpty()) {
            try {
                // Enregistrer le fichier image sur le serveur
                String fileName = file.getOriginalFilename();
                String filePath = "/chemin/vers/le/dossier/images/" + fileName; // Spécifiez le chemin de destination approprié
                file.transferTo(new File(filePath));

                // Mettre à jour l'objet Operation avec l'URL ou le chemin du fichier image
                operation.setImageUrl(filePath);
            } catch (IOException e) {
                // Gérer l'erreur lors de l'enregistrement du fichier image
                throw new RuntimeException("Error saving image file");
            }
        }

        // Ajouter l'opération en l'associant au crédit
        return operationService.addOperation(operation);
    }


*/

}




