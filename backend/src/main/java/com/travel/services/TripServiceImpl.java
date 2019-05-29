package com.travel.services;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.travel.models.Trip;
import com.travel.models.UserTrip;
import com.travel.repositories.TripRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private TripRepository tripRepository;

    @Override
    public void save(Trip trip) {
        // Just a helper to print out all object properties before saving
        try {
            for (Field field : trip.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(trip);
                System.out.printf("%s: %s%n", name, value);
            }
        } catch(IllegalAccessException error) {
            System.out.printf("exception", error);
        }

        tripRepository.save(trip);
    }

    @Override
    public Trip findById(Long tripId){
        Optional<Trip> trip = tripRepository.findById(tripId);

        if (trip.isPresent()) {
            return trip.get();
        }

        return null;
    }

    @Override
    public List<Trip> findAll() {
        return tripRepository.findAll();
    }

    @Override
    public List<Trip> findByOrganizerId(Long userId){
        List<Trip> trips = tripRepository.findAll();
        List<Trip> organizerTrips = new ArrayList<>();

        for (Trip trip: trips) {
            if (trip.getOrganizer().getId() == userId) {
                organizerTrips.add(trip);
            }
        }

        return organizerTrips;
    }

    @Override
    public void deleteById(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public void merge(Long id, Long mergedId) {
        Optional<Trip> tripOpt = tripRepository.findById(id);
        Optional<Trip> mergedTripOpt = tripRepository.findById(mergedId);

        if (!mergedTripOpt.isPresent() || !tripOpt.isPresent()) {
            return;
        }

        Trip mergedTrip = mergedTripOpt.get();
        Trip trip = tripOpt.get();

        Set<UserTrip> userTrips = mergedTrip.getUserTrips();
        trip.getUserTrips().addAll(userTrips);

        tripRepository.save(trip);
        tripRepository.deleteById(mergedId);
    }
}