package com.travel.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="amenities")
public class Amenity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "amenity")
    private Set<AmenityItem> amenityItems;

    public long getId() {
        return this.id;
    }


    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }

    public Set<AmenityItem> getAmenityItems() {
        return this.amenityItems;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmenityItems(Set<AmenityItem> amenityItems) {
        this.amenityItems = amenityItems;
    }
}