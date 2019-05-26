package com.travel.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToMany
    private Set<User> users;
    private BigDecimal price;
    private String name;
    @ManyToOne
    private Location location;
    @ManyToOne
    private Route route;

    public Accommodation() {
    }

    public Accommodation(long id, Set<User> users, BigDecimal price, String name, Location location) {
        this.id = id;
        this.users = users;
        this.price = price;
        this.name = name;
        this.location = location;
        this.users = users;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
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
}