package com.travel.controllers;

import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.Route;
import com.travel.models.User;
import com.travel.services.AccommodationService;
import com.travel.services.LocationService;
import com.travel.services.RouteService;
import com.travel.services.UserService;
import com.travel.validators.AccommodationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class AccommodationController {
    @Autowired
    private AccommodationService accommodationService;
    @Autowired
    private AccommodationValidator accommodationValidator;
    @Autowired
    private LocationService locationService;
    @Autowired
    private UserService userService;
    @Autowired
    private RouteService routeService;

    @GetMapping("accommodation/create/{routeId}")
    public String createAccommodation(Model model, @PathVariable String routeId) {
        Set<Location> locations = locationService.findByIsDevBridge(true);
        Route route = routeService.findById(Long.parseLong(routeId));
        Set<User> users = route.getMembers();

        model.addAttribute("accommodationForm", new Accommodation());
        model.addAttribute("locations", locations);
        model.addAttribute("users", users);
        model.addAttribute("route", route);

        return "createAccommodation";
    }

    @PostMapping("accommodation/create/{routeId}")
    public String createAccommodation(@ModelAttribute("accommodationForm") Accommodation accommodationForm, @PathVariable String routeId, BindingResult bindingResult) {
        accommodationValidator.validate(accommodationForm, bindingResult);

        Route route = routeService.findById(Long.parseLong(routeId));
        if(bindingResult.hasErrors()){
            return "createAccommodation";
        }

        accommodationForm.setRoute(route);

        accommodationService.save(accommodationForm);

        return "redirect:/welcome";
    }
}
