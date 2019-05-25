package com.travel.controllers;

import com.travel.models.Amenity;
import com.travel.services.AmenityService;
import com.travel.validators.AmenityValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AmenityController {
    @Autowired
    private AmenityService amenityService;

    @Autowired
    private AmenityValidator amenityValidator;

    @GetMapping("/createAmenity")
    public String createService(Model model) {
        model.addAttribute("amenityForm", new Amenity());

        return "createAmenity";
    }

    @PostMapping("/createAmenity")
    public String createService(@ModelAttribute("amenityForm") Amenity amenityForm, BindingResult bindingResult) {
        amenityValidator.validate(amenityForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "createAmenity";
        }
        amenityService.save(amenityForm);

        return "redirect:/welcome";
    }
}
