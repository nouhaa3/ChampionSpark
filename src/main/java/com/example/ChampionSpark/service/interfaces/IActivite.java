package com.example.ChampionSpark.service.interfaces;

import java.util.List;
import com.example.ChampionSpark.persistance.entities.Activite;

public interface IActivite {

    Activite saveActivite(Activite activite);
    Activite updateActivite(Activite activite);
    boolean deleteActivite(Long idact);
    List<Activite> getListActivite();
    Activite getActivite(Long idact);
    Activite findActiviteByNom(String nom);
    int getQuantityOfActivite();
    Activite getActiviteByIdActivite(Long idact);
}