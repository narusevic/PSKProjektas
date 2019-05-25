package com.travel.controllers;

import com.travel.models.*;
import com.travel.services.TripService;
import com.travel.services.UserService;
import com.travel.services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.HashSet;


@Controller
public class RouteController {
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteService routeService;
    @Autowired
    private UserService userService;

    // TODO: add acl
    // @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/route/create/{tripId}")
    public String create(Model model, @PathVariable String tripId) {
        Trip trip = tripService.findById(Long.parseLong(tripId));

        if (trip == null) {
            model.addAttribute("message", "Trip with id " + tripId + " not found!");
            return "error";
        }

        model.addAttribute("trip", trip);
        model.addAttribute("routeForm", new Route());
        
        return "createRoute";
    }

    @PostMapping("/route/create")
    public String create(@ModelAttribute("routeForm") Route routeForm, BindingResult bindingResult, Principal principal) {
        // TODO: Implement location service
        // Location startPlace = new Location();
        // Location destination = new Location();
        // tripForm.setStartPlace(startPlace);
        // tripForm.setDestination(destination);

        User user = userService.findByEmail(principal.getName());
        routeForm.setAccommodations(new HashSet<Accommodation>());
        routeForm.setCheckList(new HashSet<ServiceItem>());
        routeForm.setMembers(new HashSet<User>());

        routeService.save(routeForm);

        return "redirect:/welcome";
    }
}