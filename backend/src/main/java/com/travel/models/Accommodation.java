package com.travel.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name="accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private BigDecimal price;
    private String name;
    @ManyToOne
    private Location location;

    @ManyToOne
    private Route route;

    @OneToMany
    private Set<UserAccommodation> userAccommodation;

    public Accommodation() {
    }

    public Accommodation(long id, BigDecimal price, String name, Location location) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<UserAccommodation> getUserAccommodation() {
        return userAccommodation;
    }

    public void setUserAccommodation(Set<UserAccommodation> userAccommodation) {
        this.userAccommodation = userAccommodation;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
