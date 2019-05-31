package com.travel.services;

import com.travel.models.Accommodation;
import com.travel.models.Location;
import com.travel.models.UserAccommodation;
import com.travel.repositories.LocationRepository;
import com.travel.repositories.UserAccommodationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private UserAccommodationRepository userAccommodationRepository;

    @Override
    public List<Location> findAll(){
        return locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(Long id) {
        return locationRepository.findById(id);
    }

    @Override
    public Set<Location> findByCity(String city) {
        return locationRepository.findByCity(city);
    }

    @Override
    public Set<Location> findByCountry(String country) {
        return locationRepository.findByCountry(country);
    }

    @Override
    public Set<Location> findByIsDevBridge(boolean isDevBridge) {
        return locationRepository.findByIsDevBridge(isDevBridge);
    }

    @Override
    public void save(Location location) {
        locationRepository.save(location);
    }

    @Override
    public Integer isAvailable(Long locationId, Date from, Date to) {
        Optional<Location> locationOpt = locationRepository.findById(locationId);
        Integer result = 0;

        if (!locationOpt.isPresent()) {
            return result;
        }

        Location location = locationOpt.get();

        for (Accommodation accommodation: location.getAccomodations()) {
            List<UserAccommodation> fromUserAccomodations = userAccommodationRepository.findAllByArrivalDateBetweenAndAccommodation(from, to, accommodation);
            List<UserAccommodation> toUserAccomodations = userAccommodationRepository.findAllByDepartureDateBetweenAndAccommodation(from, to, accommodation);

            for (UserAccommodation userAccomodation: toUserAccomodations){
                if (!fromUserAccomodations.contains(userAccomodation)) {
                    fromUserAccomodations.add(userAccomodation);
                }
            }

            result += fromUserAccomodations.size();
        }

        return result;
    }
}