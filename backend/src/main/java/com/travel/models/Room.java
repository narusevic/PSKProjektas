package com.travel.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private int number;

    @ManyToOne
    private Location location;

    public long getId() {
        return this.id;
    }

    public int getNumber() {
        return this.number;
    }

    public Location getLocation() {
        return location;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
