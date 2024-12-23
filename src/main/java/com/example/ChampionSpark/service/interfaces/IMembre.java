package com.example.ChampionSpark.service.interfaces;

import java.util.List;
import com.example.ChampionSpark.persistance.entities.Membre;

public interface IMembre {

    Membre saveMembre(Membre membre);
    Membre updateMembre(Membre membre);
    boolean deleteMembre(Long idmem);
    List<Membre> getListMembre();
    Membre getMembre(Long idmem);
    Membre findMembreByEmail(String email);
    int getQuantityOfMembre();
    Membre getMembreByIdMembre(Long idmem);
    
}
