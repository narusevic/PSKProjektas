package com.travel.services;

import java.lang.reflect.Field;
import java.util.List;

import com.travel.models.Invitation;
import com.travel.repositories.InvitationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvitationServiceImpl implements InvitationService {
    @Autowired
    private InvitationRepository invitationRepository;

    @Override
    public void save(Invitation invitation) {
        // Just a helper to print out all object properties before saving
        try {
            for (Field field : invitation.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(invitation);
                System.out.printf("%s: %s%n", name, value);
            }
        } catch(IllegalAccessException error) {
            System.out.printf("exception", error);
        }

        invitationRepository.save(invitation);
    }

    @Override
    public List<Invitation> findAll() {
        return invitationRepository.findAll();
    }

    @Override
    public void deleteById(Long invitationId) {
        invitationRepository.deleteById(invitationId);
    } 

    @Override
    public Invitation findOneByEmail(String email) {
        List<Invitation> invitations = invitationRepository.findByEmail(email);

        if (invitations.size() > 0) {
            return invitations.get(0);
        }

        return null;
    } 
}