package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Salle;

public interface SalleRepository extends JpaRepository<Salle, Long> {
}
