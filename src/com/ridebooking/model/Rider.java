package com.ridebooking.model;

public class Rider {

    /* Rider main important class
    * Private variable covering encapsulation */

    private int id;
    private String name;
    private Location location;

    public Rider(int id, String name, Location location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }
    // we will not have setters for the variables.
    // Ride ID will auto-generate and Control access through methods.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Rider{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location=" + location +
                '}';
    }
}
