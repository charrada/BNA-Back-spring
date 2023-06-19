package bna.projet.Services;

import bna.projet.Repository.*;
import bna.projet.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TypePaiementOperationService implements ITypePaiementOperationService {


    @Autowired
    private TypePaiementOperationRepository typePaiementOperationRepository;

    @Override

    public List<TypePaiementOperation> findAllTypePaiementOperation() {
        return typePaiementOperationRepository.findAll();
    }
}


