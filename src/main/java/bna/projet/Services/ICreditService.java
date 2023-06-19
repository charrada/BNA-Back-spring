package bna.projet.Services;

import bna.projet.entities.Credit;

import java.util.List;

public interface ICreditService {

    Credit addCredit(Credit c);


    List<Credit> findAllCredit();
}
