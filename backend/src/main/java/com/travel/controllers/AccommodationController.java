package com.travel.controllers;

import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.User;
import com.travel.services.AccommodationService;
import com.travel.services.LocationService;
import com.travel.services.UserService;
import com.travel.validators.AccommodationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
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

    // TODO: use route id in create method, as follows: "accommodation/create/{routeid}

    @GetMapping("accommodation/create")
    public String createAccommodation(Model model) {
        Set<Location> locations = locationService.findByIsDevBridge(true);
        List<User> users = userService.findAll();
        model.addAttribute("accommodationForm", new Accommodation());
        model.addAttribute("locations", locations);
        model.addAttribute("users", users);

        return "createAccommodation";
    }

    @PostMapping("accommodation/create")
    public String createAccommodation(@ModelAttribute("accommodationForm") Accommodation accommodationForm, BindingResult bindingResult) {
        accommodationValidator.validate(accommodationForm, bindingResult);

        if(bindingResult.hasErrors()){
            return "createAccommodation";
        }

        // TODO: implement userOccupation record creation when new accommodation fact is created.
        accommodationService.save(accommodationForm);

        return "redirect:/welcome";
    }
}
