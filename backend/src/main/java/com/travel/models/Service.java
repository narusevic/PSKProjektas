package com.travel.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="services")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "services")
    private Set<ServiceItem> serviceItems;

    public long getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return this.name;
    }

    public Set<ServiceItem> getServiceItems() {
        return this.serviceItems;
    }
}