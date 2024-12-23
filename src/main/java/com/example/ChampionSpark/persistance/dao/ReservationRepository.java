package com.example.ChampionSpark.persistance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.ChampionSpark.persistance.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
