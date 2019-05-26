package com.travel.controllers;

import java.security.Principal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.travel.models.Location;
import com.travel.models.Route;
import com.travel.models.Status;
import com.travel.models.Trip;
import com.travel.models.User;
import com.travel.models.UserTrip;
import com.travel.services.LocationService;
import com.travel.services.TripService;
import com.travel.services.UserService;
import com.travel.services.UserTripService;

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
    private UserTripService userTripService;
    @Autowired
    private UserService userService;
    @Autowired
    private LocationService locationService;

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @GetMapping("/trip/create")
    public String create(Model model) {
        Set<Location> locations = locationService.findByIsDevBridge(true);
        model.addAttribute("tripForm", new Trip());
        model.addAttribute("statuses", Status.values());
        model.addAttribute("locations", locations);

        return "createTrip";
    }

    @GetMapping("/trip")
    public String getTrips(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Trip> trips = tripService.findByOrganizerId(user.getId());
        List<User> participants = userService.findAll();
        model.addAttribute("participantForm", new UserTrip());
        model.addAttribute("trips", trips);
        model.addAttribute("participants", participants);

        return "tripsList";
    }

    @PostMapping("/trip/addParticipant/{tripId}")
    public String addParticipant(@ModelAttribute("participantForm") UserTrip participantForm, @PathVariable String tripId) {
        Trip trip = tripService.findById(Long.parseLong(tripId));
        participantForm.setTrip(trip);
        if (userTripService.findOneByUserAndTrip(participantForm.getUser(), trip) != null) {
            return "tripsList";
        }

        userTripService.save(participantForm);

        return "redirect:/trip";
    }

    @GetMapping("/trip/my")
    public String getParticipantTrips(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<UserTrip> userTrips = userTripService.findByUser(user);
        model.addAttribute("userTrips", userTrips);

        return "participantTrips";
    }

    @PostMapping("/trip/approve/{tripId}")
    public String approveTrip(@PathVariable String tripId, Principal principal) {
        Trip trip = tripService.findById(Long.parseLong(tripId));
        User user = userService.findByEmail(principal.getName());
        userTripService.approveTrip(user, trip);

        return "redirect:/trip/my";
    }

    @PostMapping("/trip/delete/{tripId}")
    public String deleteUserTrip(@PathVariable String tripId, Principal principal) {
        Trip trip = tripService.findById(Long.parseLong(tripId));
        User user = userService.findByEmail(principal.getName());
        userTripService.deleteUserTrip(user, trip);

        return "redirect:/trip/my";
    }

    @PreAuthorize("hasAuthority('ORGANIZER')")
    @PostMapping("/trip/create")
    public String create(@ModelAttribute("tripForm") Trip tripForm, BindingResult bindingResult, Principal principal) {

        User user = userService.findByEmail(principal.getName());
        tripForm.setOrganizer(user);
        tripForm.setRoutes(new HashSet<Route>());
        tripForm.setUserTrips(new HashSet<UserTrip>());

        tripService.save(tripForm);

        return "redirect:/trip";
    }
    @GetMapping("/organizer")
    public String createOrganizer(Model model) {
        return "organizerDashboard";
    }
}