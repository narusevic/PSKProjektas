package com.travel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="app_user_accommodations")
public class UserAccommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Accommodation accommodation;

    private Date arrivalDate;
    private Date departureDate;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Accommodation getAccommodation() {
        return this.accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }

    public Date getArrivalDate() {
        return this.arrivalDate;
    }

    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public Date getDepartureDate() {
        return this.departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
}