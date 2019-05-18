package com.travel.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="routes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Location from;
    private Location to;
    private Date departureTime;
    private Date arrivalTime;
    private List<ServiceItem> checkList;
    private List<Accommodation> accommodations;
    private List<User> members;

    private long getId() {
        return this.id;
    }

    private Location getFrom() {
        return this.from;
    }

    private Location getTo() {
        return this.to;
    }

    private Date getDepartureTime() {
        return this.departureTime;
    }

    private Date getArrivalTime() {
        return this.arrivalTime;
    }

    private List<ServiceItem> getCheckList() {
        return this.checkList;
    }

    private List<Accommodation> getAccommodations() {
        return this.accommodations;
    }

    private List<User> getMembers() {
        return this.members;
    }
}
