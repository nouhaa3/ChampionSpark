package com.example.ChampionSpark.service.interfaces;


import java.util.List;
import com.example.ChampionSpark.persistance.entities.Salle;

public interface ISalle {

    Salle saveSalle(Salle salle);
    Salle updateSalle(Salle salle);
    boolean deleteSalle(Long idsalle);
    List<Salle> getListSalle();
    Salle getSalle(Long idsalle);
    Salle findSalleByEmplacement(String emplacement);
    int getQuantityOfSalle();
    Salle getSalleByIdSalle(Long idsalle);
}

