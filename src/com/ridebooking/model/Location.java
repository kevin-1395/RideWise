package com.ridebooking.model;

public class Location {
    /* Why we need this class, because Ride and Driver need a relationship
    So location is necessary and dependant for both the entities.
    Rider has a location. CurrentDriver get CurrentLocation().
     */

    private double x;
    private double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public double distanceTo(Location other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;

        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
