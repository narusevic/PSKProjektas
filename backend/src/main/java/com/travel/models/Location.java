package com.travel.models;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String city;
    private String country;
    private boolean isDevBridge;
    @Nullable
    @OneToMany(mappedBy = "location")
    private Set<Room> rooms;
    @Nullable
    @OneToMany(mappedBy = "location")
    private Set<Accommodation> accommodations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDevBridge() {
        return this.isDevBridge;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Accommodation> getAccomodations() {
        return this.accommodations;
    }

    public void setAccomodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}