package com.example.ChampionSpark.service.impliments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ChampionSpark.persistance.dao.ReservationRepository;
import com.example.ChampionSpark.persistance.entities.Inscription;
import com.example.ChampionSpark.persistance.entities.Reservation;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteReservation(Long idres) {
        reservationRepository.deleteById(idres);
    }

    public Reservation getReservationByIdres(Long idres) {
        return reservationRepository.findById(idres)
        .orElseThrow(() -> new RuntimeException("Reservation not found with id: " + idres));
    }
    
}
