package com.example.ChampionSpark.persistance.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpaiem;

    @ManyToOne
    @JoinColumn(name = "membre_id", referencedColumnName = "idmem")
    private Membre membre;

    private float montant;
    private LocalDate datePaiement;
    private String typePaiement;

    // Getters et Setters
    public Long getIdpaiem() {
        return idpaiem;
    }

    public void setIdpaiem(Long id) {
        this.idpaiem = id;
    }

    public Membre getMembre() {
        return membre;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(String typePaiement) {
        this.typePaiement = typePaiement;
    }
}

