package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long> {
}
