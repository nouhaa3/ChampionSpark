package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Paiement;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
