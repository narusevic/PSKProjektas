package com.travel.services;

import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.User;
import com.travel.repositories.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Autowired
    private AccommodationRepository accommodationRepository;

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Set<Accommodation> findByLocation(Location location) {
        return accommodationRepository.findByLocation(location);
    }

    @Override
    public void save(Accommodation accommodation){
        accommodationRepository.save(accommodation);
    }
}
