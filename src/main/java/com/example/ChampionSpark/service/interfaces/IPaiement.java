package com.example.ChampionSpark.service.interfaces;

import java.util.List;
import com.example.ChampionSpark.persistance.entities.Paiement;

public interface IPaiement {

    Paiement savePaiement(Paiement paiement);
    Paiement updatePaiement(Paiement paiement);
    boolean deletePaiement(Long idpaiem);
    List<Paiement> getListPaiement();
    Paiement getPaiement(Long idpaiem);
    List<Paiement> findPaiementByMembreId(Long idmem);
    int getQuantityOfPaiement();
    Paiement getPaiementByIdPaiement(Long idpaiem);
}
