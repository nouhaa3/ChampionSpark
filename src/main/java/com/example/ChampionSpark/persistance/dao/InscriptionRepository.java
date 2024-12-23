package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
