package com.example.ChampionSpark.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idres;

    @ManyToOne
    @JoinColumn(name = "salle_id", referencedColumnName = "idsalle")
    private Salle salle;

    @ManyToOne
    @JoinColumn(name = "activite_id", referencedColumnName = "idact")
    private Activite activite;

    private LocalDate dateReservation;
    private String heureDebut;
    private String heureFin;

    // Getters et Setters
    public Long getIdres() {
        return idres;
    }

    public void setIdres(Long id) {
        this.idres = id;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }
}
