package com.example.ChampionSpark.service.controller;

import java.util.List;
import java.util.Optional;

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
import com.example.ChampionSpark.persistance.entities.Reservation;
import com.example.ChampionSpark.persistance.entities.Salle;
import com.example.ChampionSpark.service.impliments.ActiviteService;
import com.example.ChampionSpark.service.impliments.InscriptionService;
import com.example.ChampionSpark.service.impliments.MembreService;
import com.example.ChampionSpark.service.impliments.ReservationService;
import com.example.ChampionSpark.service.impliments.SalleService;

@Controller
@RequestMapping("/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private final ActiviteService activiteService;
    private final SalleService salleService;
    
    public ReservationController(ReservationService reservationService, ActiviteService activiteService, SalleService salleService) {
        this.reservationService = reservationService;
        this.activiteService = activiteService;
        this.salleService = salleService;
    }
    
    @GetMapping
    public String viewReservationsPage(Model model) {
    	List<Reservation> listReservations = reservationService.getAllReservations();
        model.addAttribute("listReservations", listReservations);
        return "listereservation";
    }

    @GetMapping("/ajouter")
    public String showNewReservationForm(Model model) {
    	List<Activite> activites = activiteService.getAllActivites();
    	List<Salle> salles = salleService.getAllSalles();
    	
    	model.addAttribute("activites", activites);
    	model.addAttribute("salles", salles);
        model.addAttribute("reservation", new Reservation());
        return "ajoutreservation";
    }

    @PostMapping("/save")
    public String saveReservation(@Validated @ModelAttribute Reservation reservation, BindingResult result) {
        if (result.hasErrors()) {
        	result.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
        	return "ajoutreservation";
        }
        if (reservation.getIdres() != null) {
        	Reservation existingReservation = reservationService.getReservationByIdres(reservation.getIdres());
        	if (existingReservation != null) {
        		existingReservation.setActivite(reservation.getActivite());
        		existingReservation.setActivite(reservation.getActivite());
        		existingReservation.setDateReservation(reservation.getDateReservation());
        		existingReservation.setHeureDebut(reservation.getHeureDebut());
        		existingReservation.setHeureFin(reservation.getHeureFin());
        		reservationService.saveReservation(reservation);
        		return "redirect:/reservations";
        	}
        }
        reservationService.saveReservation(reservation);
        return "redirect:/reservations";
    		
    }

    @GetMapping("/edit/{idres}")
    public String showEditReservationForm(@PathVariable Long idres, Model model) {
        Reservation reservation = reservationService.getReservationByIdres(idres);
        List<Activite> activites = activiteService.getAllActivites();
    	List<Salle> salles = salleService.getAllSalles();
    	
    	model.addAttribute("activites", activites);
    	model.addAttribute("salles", salles);
        model.addAttribute("reservation", reservation);
        return "ajoutreservation";
    }

    @GetMapping("/delete/{idres}")
    public String deleteReservation(@PathVariable Long idres) {
        reservationService.deleteReservation(idres);
        return "redirect:/reservations";
    }
}
