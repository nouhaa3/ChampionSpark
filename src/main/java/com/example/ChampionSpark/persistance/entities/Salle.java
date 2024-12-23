package com.example.ChampionSpark.persistance.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Salle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsalle;
    private String nom;
    private String type;
    private int capacite;
    private String emplacement;

    @OneToMany(mappedBy = "salle", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters et Setters
    public Long getIdsalle() {
        return idsalle;
    }

    public void setIdsalle(Long id) {
        this.idsalle = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
