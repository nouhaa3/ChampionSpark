package com.example.ChampionSpark.service.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ChampionSpark.persistance.entities.Activite;
import com.example.ChampionSpark.service.impliments.ActiviteService;

@Controller
@RequestMapping("/activites")
public class ActiviteController {
    @Autowired
    private ActiviteService activiteService;
    
    @GetMapping
    public String viewActivitesPage(Model model) {
        model.addAttribute("listActivites", activiteService.getAllActivites());
        return "listeactivite";
    }

    @GetMapping("/ajouter")
    public String showNewActiviteForm(Model model) {
        Activite activite = new Activite();
        model.addAttribute("activite", activite);
        return "ajoutactivite";
    }

    @PostMapping("/save")
    public String saveActivite(@ModelAttribute Activite activite) {
        activiteService.saveActivite(activite);
        return "redirect:/activites";
    }

    @GetMapping("/edit/{idact}")
    public String showEditActiviteForm(@PathVariable Long idact, Model model) {
        Optional<Activite> activite = activiteService.getActiviteByIdact(idact);
        if (activite.isEmpty()) {
            model.addAttribute("error", "Activity not found");
            return "error"; 
        }
        model.addAttribute("activite", activite.get()); 
        return "ajoutactivite";
    }

    @GetMapping("/delete/{idact}")
    public String deleteActivite(@PathVariable Long idact) {
        if (activiteService.getActiviteByIdact(idact) != null) {
            activiteService.deleteActivite(idact); 
        } else {
            return "redirect:/activites?error=notfound";
        }
        return "redirect:/activites";  
    }

}
