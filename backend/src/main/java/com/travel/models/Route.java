package com.travel.models;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Location origin;
    @ManyToOne
    private Location destination;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date departureTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date arrivalTime;
    @OneToMany(mappedBy = "route")
    private Set<AmenityItem> checkList;
    @OneToMany(mappedBy = "route")
    private Set<Accommodation> accommodations;

    @ManyToMany
    private Set<User> members;

    @ManyToOne
    private Trip trip;

    public long getId() {
        return this.id;
    }

    public Location getOrigin() {
        return this.origin;
    }

    public void setOrigin(Location origin) {
        this.origin = origin;
    }

    public Location getDestination() {
        return this.destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return this.arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Set<AmenityItem> getCheckList() {
        return this.checkList;
    }

    public void setCheckList(Set<AmenityItem> checkList) {
        this.checkList = checkList;
    }

    public Set<Accommodation> getAccommodations() {
        return this.accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }

    public Set<User> getMembers() {
        return this.members;
    }

    public void setMembers(Set<User> members) {
        this.members = members;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}