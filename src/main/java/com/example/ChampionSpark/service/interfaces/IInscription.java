package com.example.ChampionSpark.service.interfaces;


import java.util.List;
import com.example.ChampionSpark.persistance.entities.Inscription;

public interface IInscription {

    Inscription saveInscription(Inscription inscription);
    Inscription updateInscription(Inscription inscription);
    boolean deleteInscription(Long idinsc);
    List<Inscription> getListInscription();
    Inscription getInscription(Long idinsc);
    List<Inscription> findInscriptionByMembreId(Long idmem);
    int getQuantityOfInscription();
    Inscription getInscriptionByIdInscription(Long idinsc);
}
