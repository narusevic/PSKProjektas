package com.travel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Location from;
    @ManyToOne
    private Location to;
    private Date departureTime;
    private Date arrivalTime;
    @OneToMany
    private Set<ServiceItem> checkList;
    @OneToMany
    private Set<Accommodation> accommodations;

    @ManyToMany
    private Set<User> members;

    @ManyToMany
    private Set<Trip> trips;

    public long getId() {
        return this.id;
    }

    public Location getFrom() {
        return this.from;
    }

    public Location getTo() {
        return this.to;
    }

    public Date getDepartureTime() {
        return this.departureTime;
    }

    public Date getArrivalTime() {
        return this.arrivalTime;
    }

    public Set<ServiceItem> getCheckList() {
        return this.checkList;
    }

    public Set<Accommodation> getAccommodations() {
        return this.accommodations;
    }

    public Set<User> getMembers() {
        return this.members;
    }

    public Set<Trip> getTrips() {
        return this.trips;
    }
}
