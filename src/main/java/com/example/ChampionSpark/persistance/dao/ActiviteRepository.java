package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Activite;

public interface ActiviteRepository extends JpaRepository<Activite, Long> {
}
