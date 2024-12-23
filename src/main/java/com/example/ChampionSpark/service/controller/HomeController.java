package com.example.ChampionSpark.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // Route pour la page d'accueil
    @GetMapping("/")
    public String showHomePage(Model model) {
        // Vous pouvez ajouter des attributs au modèle ici si nécessaire
        model.addAttribute("clubName", "ChampionSpark");
        
        // Cette méthode retourne la vue "index" qui correspond à votre fichier Thymeleaf
        return "homepage";
    }
    
    @GetMapping("/homepage2")
    public String showHomePage2(Model model) {
        // Vous pouvez ajouter des attributs au modèle pour cette page
        model.addAttribute("clubName", "ChampionSpark");
        
        // Cette méthode retourne la vue "home2" qui correspond à votre fichier Thymeleaf
        return "homepage2";
    }
    
}
