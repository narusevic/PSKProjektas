package com.travel.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;

import com.travel.models.*;
import com.travel.services.TripService;
import com.travel.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TripController {
    @Autowired
    private TripService tripService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/trip/create")
    public String create(Model model) {
        model.addAttribute("tripForm", new Trip());
        model.addAttribute("statuses", Status.values());

        return "createTrip";
    }

    @GetMapping("/trip")
    public String getTrips(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Trip> trips = tripService.findAll();
        List<User> participants = userService.findAll();
        model.addAttribute("participantForm", new UserTrip());
        model.addAttribute("trips", trips);
        model.addAttribute("participants", participants);
        return "tripsList";
    }

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PostMapping("/trip/create")
    public String create(@ModelAttribute("tripForm") Trip tripForm, BindingResult bindingResult, Principal principal) {
        // TODO: Implement location service
        // Location startPlace = new Location();
        // Location destination = new Location();
        // tripForm.setStartPlace(startPlace);
        // tripForm.setDestination(destination);

        User user = userService.findByEmail(principal.getName());
        tripForm.setOrganizer(user);
        tripForm.setRoutes(new HashSet<Route>());
        tripForm.setUsers(new HashSet<User>());

        tripService.save(tripForm);

        return "redirect:/welcome";
    }
    @GetMapping("/organizer")
    public String createOrganizer(Model model) {
        return "organizerDashboard";
    }
}
