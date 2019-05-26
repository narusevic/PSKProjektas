package com.travel.controllers;

import com.travel.models.*;
import com.travel.services.LocationService;
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
import java.util.Set;


@Controller
public class RouteController {
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteService routeService;

    @Autowired
    private LocationService locationService;

    // TODO: add acl
    // @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/route/create/{tripId}")
    public String create(Model model, @PathVariable String tripId) {
        Trip trip = tripService.findById(Long.parseLong(tripId));
        Set<Location> locations = locationService.findByIsDevBridge(true);

        if (trip == null) {
            model.addAttribute("message", "Trip with id " + tripId + " not found!");
            return "error";
        }

        model.addAttribute("trip", trip);
        model.addAttribute("routeForm", new Route());
        model.addAttribute("locations", locations);
        
        return "createRoute";
    }

    @PostMapping("/route/create/{tripId}")
    public String create(@ModelAttribute("userForm") Route routeForm, @PathVariable String tripId, BindingResult bindingResult) {
        // TODO: Implement location service
        // Location startPlace = new Location();
        // Location destination = new Location();
        // tripForm.setStartPlace(startPlace);
        // tripForm.setDestination(destination);

        Trip trip = tripService.findById(Long.parseLong(tripId));

        routeForm.setAccommodations(new HashSet<Accommodation>());
        routeForm.setCheckList(new HashSet<AmenityItem>());
        routeForm.setMembers(new HashSet<User>());
        routeForm.setTrip(trip);

        routeService.save(routeForm);

        return "redirect:/trip";
    }
}