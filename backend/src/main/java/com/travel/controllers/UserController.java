package com.travel.controllers;

import java.util.List;

import com.travel.models.Invitation;
import com.travel.models.User;
import com.travel.services.InvitationService;
import com.travel.services.SecurityService;
import com.travel.services.UserService;
import com.travel.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private InvitationService invitationService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @GetMapping("/admin/user")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminUsers(Model model) {
        List<User> users = userService.findAll();
        List<Invitation> invitations = invitationService.findAll();

        model.addAttribute("users", users);
        model.addAttribute("invitations", invitations);
        model.addAttribute("invitationForm", new Invitation());

        return "adminUsers";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/invitation")
    public String createInvitation(@ModelAttribute("invitationForm") Invitation invitationForm) {
        invitationService.save(invitationForm);

        return "redirect:/admin/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/user/{userId}")
    public String deleteUser(@PathVariable String userId) {
        userService.deleteById(Long.parseLong(userId));

        return "redirect:/admin/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/invitation/{invitationId}")
    public String deleteInvitation(@PathVariable String invitationId) {
        invitationService.deleteById(Long.parseLong(invitationId));

        return "redirect:/admin/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/admin/changeOrganizer/{userId}")
    public String changeOrganizer(@PathVariable String userId) {
        User user = userService.findById(Long.parseLong(userId));

        if (userService.hasRole(user, "ORGANIZER")) {
            System.out.println("remove role");
            userService.removeRole(user, "ORGANIZER");
        } else {
            System.out.println("add role");
            userService.addRole(user, "ORGANIZER");
        }

        return "redirect:/admin/user";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        Invitation invitation = invitationService.findOneByEmail(userForm.getEmail());

        if (invitation == null) {
            return "registration";
        }

        invitationService.deleteById(invitation.getId());
        userService.save(userForm);

        securityService.autoLogin(userForm.getEmail(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your email and password is invalid.");

        if (logout != null) 
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @GetMapping({"/", "/welcome"})
    public String welcome(Model model) {
        return "welcome";
    }
}