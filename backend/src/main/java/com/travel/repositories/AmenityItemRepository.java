package com.travel.repositories;

import com.travel.models.Amenity;
import com.travel.models.AmenityItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface AmenityItemRepository extends JpaRepository<AmenityItem, Long> {
    Optional<AmenityItem> findById(Long id);
    Set<AmenityItem> findByAmenity(Amenity amenity);

}
