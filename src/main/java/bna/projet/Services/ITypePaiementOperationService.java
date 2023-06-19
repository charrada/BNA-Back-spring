package bna.projet.Services;

import bna.projet.entities.TypePaiementOperation;

import java.util.List;

public interface ITypePaiementOperationService {

    List<TypePaiementOperation> findAllTypePaiementOperation();
}
