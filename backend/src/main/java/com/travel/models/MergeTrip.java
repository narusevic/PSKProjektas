package com.travel.models;

import javax.persistence.*;

@Entity
public class MergeTrip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long baseId;
    private long mergeId;

    public long getBaseId() {
        return baseId;
    }

    public void setBaseId(long baseId) {
        this.baseId = baseId;
    }

    public long getMergeId() {
        return mergeId;
    }

    public void setMergeId(long mergeId) {
        this.mergeId = mergeId;
    }

}
