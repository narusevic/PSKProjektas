package com.travel.repositories;

import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
    Optional<Accommodation> findById(Long id);
    Set<Accommodation> findByLocation(Location location);
}
