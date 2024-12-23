package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.ActiviteRepository;
import com.example.ChampionSpark.persistance.entities.Activite;

import java.util.List;
import java.util.Optional;

@Service
public class ActiviteService {
    @Autowired
    private ActiviteRepository activiteRepository;

    public List<Activite> getAllActivites() {
        return activiteRepository.findAll();
    }

    public Activite saveActivite(Activite activite) {
        return activiteRepository.save(activite);
    }

    public void deleteActivite(Long idact) {
        activiteRepository.deleteById(idact);
    }

    public Optional<Activite> getActiviteByIdact(Long idact) {
        return activiteRepository.findById(idact);
    }
}
