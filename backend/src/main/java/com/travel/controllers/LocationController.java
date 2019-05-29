package com.travel.controllers;

import com.travel.models.Location;
import com.travel.services.LocationService;
import com.travel.validators.LocationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LocationController {
    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationValidator locationValidator;

    @GetMapping("/createLocation")
    public String createLocation(Model model){
        model.addAttribute("locationForm",new Location());

        return "createLocation";
    }

    @PostMapping("/createLocation")
    public String createLocation(@ModelAttribute("locationForm") Location locationForm, BindingResult bindingResult) {
        locationValidator.validate(locationForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "createLocation";
        }
        locationService.save(locationForm);

        return "redirect:/welcome";
    }
}
