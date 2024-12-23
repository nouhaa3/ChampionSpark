package com.example.ChampionSpark.service.interfaces;


import java.util.List;
import com.example.ChampionSpark.persistance.entities.Reservation;

public interface IReservation {

    Reservation saveReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    boolean deleteReservation(Long idres);
    List<Reservation> getListReservation();
    Reservation getReservationSalle(Long idres);
    List<Reservation> findReservationBySalleId(Long idsalle);
    int getQuantityOfReservation();
    Reservation getReservationByIdReservation(Long idres);
}
