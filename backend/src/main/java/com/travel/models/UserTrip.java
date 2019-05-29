package com.travel.models;
import javax.persistence.*;

@Entity
@Table(name = "appUserTrips")
public class UserTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Trip trip;

    private Boolean userApproved;

    public UserTrip() {
        this.userApproved = false;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return this.trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Boolean getUserApproved() {
        return this.userApproved;
    }

    public void setUserApproved(Boolean userApproved) {
        this.userApproved = userApproved;
    }
}
