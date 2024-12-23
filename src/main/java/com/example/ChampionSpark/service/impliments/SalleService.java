package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.SalleRepository;
import com.example.ChampionSpark.persistance.entities.Salle;

import java.util.List;
import java.util.Optional;

@Service
public class SalleService {
    @Autowired
    private SalleRepository salleRepository;

    public List<Salle> getAllSalles() {
        return salleRepository.findAll();
    }

    public Salle saveSalle(Salle salle) {
        return salleRepository.save(salle);
    }

    public void deleteSalle(Long idsalle) {
        salleRepository.deleteById(idsalle);
    }

    public Optional<Salle> getSalleByIdsalle(Long idsalle) {
        return salleRepository.findById(idsalle);
    }
}
