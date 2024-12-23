package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.PaiementRepository;
import com.example.ChampionSpark.persistance.entities.Inscription;
import com.example.ChampionSpark.persistance.entities.Paiement;

import java.util.List;
import java.util.Optional;

@Service
public class PaiementService {
    @Autowired
    private PaiementRepository paiementRepository;

    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }

    public Paiement savePaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    public void deletePaiement(Long idpaiem) {
        paiementRepository.deleteById(idpaiem);
    }

    public Paiement getPaiementByIdpaiem(Long idpaiem) {
        return paiementRepository.findById(idpaiem)
        .orElseThrow(() -> new RuntimeException("Paiement not found with id: " + idpaiem));
    }
    
}

