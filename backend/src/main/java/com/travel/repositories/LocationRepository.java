package com.travel.repositories;

import com.travel.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.Set;

public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findById(Long id);
    Set<Location> findByCity(String city);
    Set<Location> findByCountry(String country);
    Set<Location> findByIsDevBridge(boolean isDevBridge);
}
