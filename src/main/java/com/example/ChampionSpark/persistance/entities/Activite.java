package com.example.ChampionSpark.persistance.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idact;
    private String nom;
    private String description;
    private String horaire;
    private Long duree;

    @OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    @OneToMany(mappedBy = "activite", cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    // Getters et Setters

    public String getNom() {
        return nom;
    }

    public Long getIdact() {
		return idact;
	}

	public void setIdact(Long idact) {
		this.idact = idact;
	}

	public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHoraire() {
        return horaire;
    }

    public void seHoraire(String horaire) {
        this.horaire = horaire;
    }

    public Long getDuree() {
        return duree;
    }

    public void setDuree(Long duree) {
        this.duree = duree;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
}
