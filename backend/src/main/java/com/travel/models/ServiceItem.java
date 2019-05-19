package com.travel.models;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name="service_items")
public class ServiceItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Service service;
    private boolean isConfirmed;
    private BigDecimal price;
    private String comment;

    public long getId() {
        return this.id;
    }

    public Service getService() {
        return this.service;
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
}
