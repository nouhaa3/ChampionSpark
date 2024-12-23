package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.MembreRepository;
import com.example.ChampionSpark.persistance.entities.Membre;

import java.util.List;
import java.util.Optional;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;

    public List<Membre> getAllMembres() {
        return membreRepository.findAll();
    }

    public Membre saveMembre(Membre membre) {
        return membreRepository.save(membre);
    }

    public void deleteMembre(Long idmem) {
        membreRepository.deleteById(idmem);
    }

    public Optional<Membre> getMembreByIdmem(Long idmem) {
        return membreRepository.findById(idmem);
    }
}