package com.travel.controllers;

import com.travel.models.*;
import com.travel.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.naming.Binding;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class AmenityItemController {
    @Autowired
    private AmenityItemService amenityItemService;
    @Autowired
    private AmenityService amenityService;

    @Autowired
    private UserService userService;
    @Autowired
    private TripService tripService;
    @Autowired
    private RouteService routeService;

    @GetMapping("amenityItem/create/{routeId}")
    public String createAmenityItem(Model model, @PathVariable String routeId) {
        Route route = routeService.findAll();
        List<Amenity> amenities = amenityService.findAll();
        model.addAttribute("amenityItemForm", new AmenityItem());
        model.addAttribute("amenities", amenities);

        return "createAmenityItem";
    }

    @PostMapping("amenityItem/create/{routeId}")
    public String createAmenityItem(@ModelAttribute("amenityItemForm") AmenityItem amenityItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "createAmenityItem";
        }

        amenityItemService.save(amenityItem);

        return "redirect:/welcome";
    }

    @PostMapping("amenityItem/confirm/{id}")
    public String confirm(@PathVariable String id, BindingResult bindingResult) {
        Optional<AmenityItem> amenityItemOptional = amenityItemService.findById(Long.parseLong(id));
        if (!amenityItemOptional.isPresent()) {
            return "redirect:/createAmenityItem";
        }

        AmenityItem amenityItem = amenityItemOptional.get();
        amenityItem.setConfirmed(true);
        amenityItemService.save(amenityItem);

        return "redirect:/welcome";
    }

    @GetMapping("/amenityItem")
    public String getAmenityItems(Model model, Principal principal) {
        User user = userService.findByEmail(principal.getName());
        List<Trip> trips = tripService.findByOrganizerId(user.getId());
        List<Route> routes = new ArrayList<Route>();
        List<AmenityItem> amenityItems = new ArrayList<AmenityItem>();

        for (Trip trip : trips) {
            Set<Route> routesOfTrip = trip.getRoutes();
            routes.addAll(routesOfTrip);
        }

        for (Route route: routes) {
            Set<AmenityItem> amenityItemsOfRoute = route.getCheckList();
            amenityItems.addAll(amenityItemsOfRoute);
        }

        model.addAttribute("amenityItems", amenityItems);

        return "amenityItemsList";
    }
}