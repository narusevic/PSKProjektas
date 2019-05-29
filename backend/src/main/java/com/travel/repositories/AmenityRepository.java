package com.travel.repositories;

import com.travel.models.Amenity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AmenityRepository extends JpaRepository<Amenity, Long> {
    Optional<Amenity> findById(Long id);
    Set<Amenity> findByName(String name);
    Set<Amenity> findByDescription(String description);
}
