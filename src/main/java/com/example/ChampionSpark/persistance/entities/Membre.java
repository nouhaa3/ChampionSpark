package com.example.ChampionSpark.persistance.entities;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
public class Membre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmem;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private LocalDate dateNaissance;

    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)
    private List<Inscription> inscriptions;

    @OneToMany(mappedBy = "membre", cascade = CascadeType.ALL)
    private List<Paiement> paiements;

    // Getters et Setters
    public Long getIdmem() {
        return idmem;
    }

    public void setIdmem(Long idmem) {
        this.idmem = idmem;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Inscription> getInscriptions() {
        return inscriptions;
    }

    public void setInscriptions(List<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}
