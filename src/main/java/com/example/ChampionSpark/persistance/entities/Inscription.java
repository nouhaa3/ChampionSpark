package com.example.ChampionSpark.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idinsc;

    @ManyToOne
    @JoinColumn(name = "membre_id", referencedColumnName = "idmem")
    private Membre membre;

    @ManyToOne
    @JoinColumn(name = "activite_id", referencedColumnName = "idact")
    private Activite activite;

    private LocalDate dateInscription;

    // Getters et Setters
    public Long getIdinsc() {
        return idinsc;
    }

    public void setIdinsc(Long id) {
        this.idinsc = id;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activite) {
        this.activite = activite;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }
}
