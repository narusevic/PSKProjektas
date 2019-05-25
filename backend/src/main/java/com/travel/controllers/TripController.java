package com.travel.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;

import com.travel.models.Location;
import com.travel.models.Route;
import com.travel.models.Status;
import com.travel.models.Trip;
import com.travel.models.User;
import com.travel.services.TripService;
import com.travel.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
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

    // TODO: add acl
    // @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/trip/create")
    public String create(Model model) {
        model.addAttribute("tripForm", new Trip());
        model.addAttribute("statuses", Status.values());

        return "createTrip";
    }

    @GetMapping("/trip")
    public String getTrips(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Trip> trips = tripService.findByOrganizerId(user.getId());
        System.out.println(trips);
        model.addAttribute("trips", trips);

        return "tripsList";
    }
 
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
}