package com.travel.controllers;

import com.travel.models.Location;
import com.travel.models.Room;
import com.travel.services.LocationService;
import com.travel.services.RoomService;
import com.travel.validators.RoomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Set;

@Controller
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private LocationService locationService;

    @Autowired
    private RoomValidator roomValidator;

    @GetMapping("/createRoom")
    public String createRoom(Model model){
        Set<Location> locations = locationService.findByIsDevBridge(true);
        model.addAttribute("roomForm", new Room());
        model.addAttribute("locations", locations);

        return "createRoom";
    }

    @PostMapping("/createRoom")
    public String createRoom(@ModelAttribute("roomForm") Room roomForm, BindingResult bindingResult){
        roomValidator.validate(roomForm, bindingResult);
        if(bindingResult.hasErrors()){
            return "createRoom";
        }

        roomService.save(roomForm);

        return "redirect:/welcome";
    }
}
