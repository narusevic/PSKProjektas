package com.travel.models;

public enum Status {
    Pending("Pending"),
    Approved("Approved"),
    Completed("Completed");

    private String value;

    private Status(String theValue) {
        this.value = theValue;
    }

    public String getValue() {
        return this.value;
    }
}
