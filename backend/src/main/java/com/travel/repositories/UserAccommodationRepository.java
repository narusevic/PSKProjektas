package com.travel.repositories;

import java.util.Date;
import java.util.List;

import com.travel.models.Accommodation;
import com.travel.models.UserAccommodation;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccommodationRepository extends JpaRepository<UserAccommodation, Long> {
    List<UserAccommodation> findAllByDepartureDateBetweenAndAccommodation(Date from, Date to, Accommodation accommodation);
    List<UserAccommodation> findAllByArrivalDateBetweenAndAccommodation(Date from, Date to, Accommodation accommodation);
}
