package com.travel.controllers;

import com.travel.models.*;
import com.travel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Controller
public class RouteController {
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteService routeService;

    @Autowired
    private LocationService locationService;
    @Autowired
    private AccommodationService accommodationService;

    @GetMapping("/route")
    public String getRoutes(Model model, Principal principal) {
        List<Route> routes = routeService.findAll();
        model.addAttribute("routes", routes);

        return "routesList";
    }

    @GetMapping("/route/{routeId}")
    public String getRoute(Model model, @PathVariable String routeId, Principal principal) {
        Route route = routeService.findById(Long.parseLong(routeId));
        Set<Accommodation> accommodations = route.getAccommodations();
        Set<AmenityItem> amenityItems = route.getCheckList();
        Set<UserTrip> userTrips = route.getTrip().getUserTrips();
        userTrips = userTrips.stream()
                .filter((userTrip) -> userTrip.getUserApproved()).collect(Collectors.toSet());
        Set<User> users = new HashSet<User>();
        for (UserTrip userTrip: userTrips) {
            users.add(userTrip.getUser());
        }
        model.addAttribute("route", route);
        model.addAttribute("accommodations", accommodations);
        model.addAttribute("amenityItems", amenityItems);
        model.addAttribute("users", users);

        return "route";
    }

    @PreAuthorize("hasAuthority('ORGANIZER')")
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

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/route/delete/{routeId}")
    public String create(@PathVariable String routeId) {
        routeService.deleteById(Long.parseLong(routeId));
        
        return "redirect:/trip";
    }

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PostMapping("/route/create/{tripId}")
    public String create(@ModelAttribute("userForm") Route routeForm, @PathVariable String tripId, BindingResult bindingResult) {
        Trip trip = tripService.findById(Long.parseLong(tripId));

        Set<UserTrip> userTrips = trip.getUserTrips();
        userTrips = userTrips.stream()
                .filter((userTrip) -> userTrip.getUserApproved()).collect(Collectors.toSet());
        Set<User> users = new HashSet<User>();
        for (UserTrip userTrip: userTrips) {
            users.add(userTrip.getUser());
        }

        Set<Accommodation> accommodations = new HashSet<Accommodation>();

        Location to = routeForm.getDestination();
        int availableRooms = locationService.isAvailable(to.getId(), routeForm.getDepartureTime(), routeForm.getArrivalTime());

        if(availableRooms < trip.getUserTrips().size()) {
            Accommodation accommodationInDevBridge = new Accommodation();
            Accommodation accommodationNotInDevBridge = new Accommodation();
            accommodationInDevBridge.setRoute(routeForm);
            accommodationNotInDevBridge.setRoute(routeForm);
            Set<User> usersInDevBridgeApartment = users.stream().limit(availableRooms).collect(Collectors.toSet());

            // accommodate the rest users to non-devbridge apartment.
            for(int i = 0;i < availableRooms;i++) {
                users.iterator().remove();
            }

            //accommodationInDevBridge.setUsers(usersInDevBridgeApartment);
            //accommodationNotInDevBridge.setUsers(users);
            accommodationService.save(accommodationInDevBridge);
            accommodationService.save(accommodationNotInDevBridge);
            accommodations.add(accommodationInDevBridge);
            accommodations.add(accommodationNotInDevBridge);
        }
        else {
            Accommodation accommodation = new Accommodation();
            accommodationService.save(accommodation);
            accommodations.add(accommodation);
        }


        routeForm.setAccommodations(accommodations);
        routeForm.setCheckList(new HashSet<AmenityItem>());
        routeForm.setMembers(new HashSet<User>());
        routeForm.setTrip(trip);

        routeService.save(routeForm);

        return "redirect:/trip";
    }
}