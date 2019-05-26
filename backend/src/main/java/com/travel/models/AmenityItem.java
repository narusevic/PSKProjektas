package com.travel.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="amenity_items")
public class AmenityItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Amenity amenity;

    private boolean isConfirmed;
    private BigDecimal price;
    private String comment;

    public long getId() {
        return this.id;
    }

    public Amenity getAmenity() {
        return this.amenity;
    }

    public boolean isConfirmed() {
        return this.isConfirmed;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public String getComment() {
        return this.comment;
    }

    public void setAmenity(Amenity amenity) {
        this.amenity = amenity;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
