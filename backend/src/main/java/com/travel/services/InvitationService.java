package com.travel.services;

import java.util.List;

import com.travel.models.Invitation;

public interface InvitationService {
    void save(Invitation invitation);

    List<Invitation> findAll();

    void deleteById(Long invitationId);

    Invitation findOneByEmail(String email);
}