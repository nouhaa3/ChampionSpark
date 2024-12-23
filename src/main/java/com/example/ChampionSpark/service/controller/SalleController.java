package com.example.ChampionSpark.service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ChampionSpark.persistance.entities.Salle;
import com.example.ChampionSpark.service.impliments.SalleService;

@Controller
@RequestMapping("/salles")
public class SalleController {
    @Autowired
    private SalleService salleService;
    
    @GetMapping
    public String viewSallesPage(Model model) {
    	List<Salle> listSalles = salleService.getAllSalles();
        model.addAttribute("listSalles", listSalles);
        return "listesalle";
    }

    @GetMapping("/ajouter")
    public String showNewSalleForm(Model model) {
        model.addAttribute("salle", new Salle());
        return "ajoutsalle";
    }

    @PostMapping("/save")
    public String saveSalle(@ModelAttribute Salle salle) {
        salleService.saveSalle(salle);
        return "redirect:/salles";
    }

    @GetMapping("/edit/{idsalle}")
    public String showEditSalleForm(@PathVariable Long idsalle, Model model) {
        Optional<Salle> salle = salleService.getSalleByIdsalle(idsalle);
        if (salle == null) {
            model.addAttribute("error", "Salle not found");
            return "error"; 
        }
        model.addAttribute("salle", salle);
        return "ajoutsalle";
    }

    @GetMapping("/delete/{idsalle}")
    public String deleteSalle(@PathVariable Long idsalle) {
    	if (salleService.getSalleByIdsalle(idsalle) != null) {
    		salleService.deleteSalle(idsalle);
        } else {
            return "redirect:/salles?error=notfound";
        }
        return "redirect:/salles";
    }
}

