package com.travel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToMany(mappedBy = "trips")
    private Set<Route> routes;
    @ManyToMany(mappedBy = "trips")
    private Set<User> users;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Date departureTime;
    private Date arrivalTime;
    private Location startPlace;
    private Location destination;
    private User organizer;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(Set<Route> routes) {
        this.routes = routes;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Location getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(Location startPlace) {
        this.startPlace = startPlace;
    }

    public Location getDestination() {
        return destination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public User getOrganizer() {
        return organizer;
    }

    public void setOrganizer(User organizer) {
        this.organizer = organizer;
    }
}