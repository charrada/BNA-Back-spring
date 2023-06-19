package bna.projet.Services;

import bna.projet.Repository.*;
import bna.projet.entities.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TypePaiementOperationService implements ITypePaiementOperationService {


    @Autowired
    private TypePaiementOperationRepository typePaiementOperationRepository;

    public List<TypePaiementOperation> findAllTypePaiementOperation() {
        return typePaiementOperationRepository.findAll();
    }
}


