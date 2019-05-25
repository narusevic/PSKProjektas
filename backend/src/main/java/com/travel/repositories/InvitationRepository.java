package com.travel.repositories;

import java.util.List;

import com.travel.models.Invitation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationRepository extends JpaRepository<Invitation, Long> {
    List<Invitation> findByEmail(String email);
}