package com.example.ChampionSpark.service.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ChampionSpark.persistance.entities.Membre;
import com.example.ChampionSpark.persistance.entities.Paiement;
import com.example.ChampionSpark.service.impliments.MembreService;
import com.example.ChampionSpark.service.impliments.PaiementService;

@Controller
@RequestMapping("/paiements")
public class PaiementController {
    @Autowired
    private PaiementService paiementService;
    private final MembreService membreService;
    
    public PaiementController(PaiementService paiementService, MembreService membreService) {
        this.paiementService = paiementService;
        this.membreService = membreService;
    }
    
    @GetMapping
    public String viewPaiementsPage(Model model) {
    	List<Paiement> listPaiements = paiementService.getAllPaiements();
        model.addAttribute("listPaiements", listPaiements);
        return "listepaiement";
    }

    @GetMapping("/ajouter")
    public String showNewPaiementForm(Model model) {
        // Récupérer la liste des membres depuis la base de données
        List<Membre> membres = membreService.getAllMembres();

        // Définir les types de paiement disponibles
        List<String> typesPaiement = Arrays.asList("Carte bancaire", "Carte E-Dinar", "Pay Pal", "Espèces");

        // Ajouter les attributs au modèle
        model.addAttribute("membres", membres);
        model.addAttribute("typesPaiement", typesPaiement); // Liste des types de paiement
        model.addAttribute("paiement", new Paiement()); // Objet vide pour le formulaire

        return "ajoutpaiement";
    }


    @PostMapping("/save")
    public String savePaiement(@Validated @ModelAttribute Paiement paiement, BindingResult result) {
        if (result.hasErrors()) {
            // Log des erreurs
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "ajoutpaiement"; // Retourner au formulaire avec les erreurs
        }

        if (paiement.getIdpaiem() != null) {
            Paiement existingPaiement = paiementService.getPaiementByIdpaiem(paiement.getIdpaiem());
            if (existingPaiement != null) {
                // Mise à jour des champs du paiement existant
                existingPaiement.setMembre(paiement.getMembre());
                existingPaiement.setMontant(paiement.getMontant());
                existingPaiement.setDatePaiement(paiement.getDatePaiement());
                existingPaiement.setTypePaiement(paiement.getTypePaiement());
                paiementService.savePaiement(existingPaiement);
                return "redirect:/paiements";
            }
        }
        // Sinon, sauvegarder un nouveau paiement
        paiementService.savePaiement(paiement);
        return "redirect:/paiements";
    }


    @GetMapping("/edit/{idpaiem}")
    public String showEditPaiementForm(@PathVariable Long idpaiem, Model model) {
        Paiement paiement = paiementService.getPaiementByIdpaiem(idpaiem);
        
        List<Membre> membres = membreService.getAllMembres();

        model.addAttribute("membre", membres);
        model.addAttribute("paiement", paiement);

        return "ajoutpaiement"; // Retourner au formulaire d'édition
    }

    @GetMapping("/delete/{idpaiem}")
    public String deletePaiement(@PathVariable Long idpaiem) {
        paiementService.deletePaiement(idpaiem);
        return "redirect:/paiements"; // Rediriger vers la liste des paiements
    }


}
