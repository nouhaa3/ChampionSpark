package com.example.ChampionSpark.service.controller;

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

import com.example.ChampionSpark.persistance.entities.Activite;
import com.example.ChampionSpark.persistance.entities.Inscription;
import com.example.ChampionSpark.persistance.entities.Membre;
import com.example.ChampionSpark.service.impliments.InscriptionService;
import com.example.ChampionSpark.service.impliments.MembreService;
import com.example.ChampionSpark.service.impliments.ActiviteService;

@Controller
@RequestMapping("/inscriptions")
public class InscriptionController {
    @Autowired
    private InscriptionService inscriptionService;
    private final ActiviteService activiteService;
    private final MembreService membreService;
    
    public InscriptionController(InscriptionService inscriptionService, MembreService membreService, ActiviteService activiteService) {
        this.inscriptionService = inscriptionService;
        this.membreService = membreService;
        this.activiteService = activiteService;
    }
    
    @GetMapping
    public String viewInscriptionsPage(Model model) {
    	List<Inscription> listInscriptions = inscriptionService.getAllInscriptions();
        model.addAttribute("listInscriptions", listInscriptions);
        return "listeinscription";
    }

    @GetMapping("/ajouter")
    public String showNewInscriptionForm(Model model) {
    	List<Membre> membres = membreService.getAllMembres();
        List<Activite> activites = activiteService.getAllActivites();
        
        model.addAttribute("membres", membres);
        model.addAttribute("activites", activites);
        model.addAttribute("inscription", new Inscription());
        return "ajoutinscription";
    }
    
    @PostMapping("/save")
    public String saveInscription(@Validated @ModelAttribute Inscription inscription, BindingResult result) {
    	if (result.hasErrors()) {
            // Log des erreurs
            result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "ajoutinscription"; // Retourner au formulaire avec les erreurs
        }
    	
        if (inscription.getIdinsc() != null) {
            Inscription existingInscription = inscriptionService.getInscriptionByIdinsc(inscription.getIdinsc());
            if (existingInscription != null) {
                // Mise à jour des champs de l'inscription existante
                existingInscription.setMembre(inscription.getMembre());
                existingInscription.setActivite(inscription.getActivite());
                existingInscription.setDateInscription(inscription.getDateInscription());
                inscriptionService.saveInscription(existingInscription);
                return "redirect:/inscriptions";
            }
        }
        // Sinon, sauvegarder une nouvelle inscription
        inscriptionService.saveInscription(inscription);
        return "redirect:/inscriptions";
    }


    @GetMapping("/edit/{idinsc}")
    public String showEditInscriptionForm(@PathVariable Long idinsc, Model model) {
        Inscription inscription = inscriptionService.getInscriptionByIdinsc(idinsc);
        List<Membre> membres = membreService.getAllMembres();
        List<Activite> activites = activiteService.getAllActivites();
        
        model.addAttribute("membre", membres);
        model.addAttribute("activite", activites);
        model.addAttribute("inscription", inscription);
        
        return "ajoutinscription";
    }

    @GetMapping("/delete/{idinsc}")
    public String deleteInscription(@PathVariable Long idinsc) {
        inscriptionService.deleteInscription(idinsc);
        return "redirect:/inscriptions";
    }
    
}
