package com.travel.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    private Set<Role> roles;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private Set<UserTrip> userTrips;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "organizer")
    private Set<Trip> organizedTrips;

    @ManyToMany
    private Set<Accommodation> accommodations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<UserTrip> getUserTrips() {
        return this.userTrips;
    }

    public void setUserTrips(Set<UserTrip> userTrips) {
        this.userTrips = userTrips;
    }

    public Set<Trip> getOrganizedTrips() {
        return this.organizedTrips;
    }

    public void setOrganizedTrips(Set<Trip> organizedTrips) {
        this.organizedTrips = organizedTrips;
    }

    @Override
    public String toString() {
        return this.getEmail();
    }

    public Set<Accommodation> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(Set<Accommodation> accommodations) {
        this.accommodations = accommodations;
    }
}