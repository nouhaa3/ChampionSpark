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

import com.example.ChampionSpark.persistance.entities.Membre;
import com.example.ChampionSpark.service.impliments.MembreService;

@Controller
@RequestMapping("/membres")
public class MembreController {
    @Autowired
    private MembreService membreService;
    
    @GetMapping
    public String viewMembresPage(Model model) {
        List<Membre> listMembres = membreService.getAllMembres();
        model.addAttribute("listMembres", listMembres); 
        return "listemembres";
    }

    @GetMapping("/ajouter")
    public String showNewMembreForm(Model model) {
        model.addAttribute("membre", new Membre());
        return "ajoutmembre";  
    }

    @PostMapping("/save")
    public String saveMembre(@ModelAttribute Membre membre) {
        membreService.saveMembre(membre);
        return "redirect:/membres";
    }

    @GetMapping("/edit/{idmem}")
    public String showEditMembreForm(@PathVariable Long idmem, Model model) {
    	Optional<Membre> membre = membreService.getMembreByIdmem(idmem);
    	if (membre == null) {
            model.addAttribute("error", "Member not found");
            return "error"; 
        }
        model.addAttribute("membre", membre); 
        return "ajoutmembre";
    }
    
    @GetMapping("/delete/{idmem}")
    public String deleteMembre(@PathVariable Long idmem) {
        if (membreService.getMembreByIdmem(idmem) != null) {
        	membreService.deleteMembre(idmem); 
        } else {
            return "redirect:/membres?error=notfound";
        }
        return "redirect:/membres";  
    }
}
