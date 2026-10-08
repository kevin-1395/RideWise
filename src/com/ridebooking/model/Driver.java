package com.ridebooking.model;

public class Driver {
    /* Driver Class */

    private int id;
    private String name;
    private Location currentLocation;
    private boolean available; // If Driver can currently receive a ride

    public Driver(int id, String name, Location currentLocation, boolean available) {
        this.id = id;
        this.name = name;
        this.currentLocation = currentLocation;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", available=" + available +
                '}';
    }
}
