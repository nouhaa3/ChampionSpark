package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.InscriptionRepository;
import com.example.ChampionSpark.persistance.entities.Inscription;

import java.util.List;
import java.util.Optional;

@Service
public class InscriptionService {
    @Autowired
    private InscriptionRepository inscriptionRepository;

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll();
    }

    public Inscription saveInscription(Inscription inscription) {
        return inscriptionRepository.save(inscription);
    }

    public void deleteInscription(Long idinsc) {
        inscriptionRepository.deleteById(idinsc);
    }

    public Inscription getInscriptionByIdinsc(Long idinsc) {
        return inscriptionRepository.findById(idinsc)
        .orElseThrow(() -> new RuntimeException("Inscription not found with id: " + idinsc));
    }
}
