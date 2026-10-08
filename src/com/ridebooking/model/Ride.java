package com.ridebooking.model;

public class Ride {

    private int id;
    private Rider rider;
    private Driver driver;
    private double distance;
    private RideStatus status;

    public Ride(int id, Rider rider, double distance, RideStatus status) {
        this.id = id;
        this.rider = rider;
        this.distance = distance;
        this.status = RideStatus.REQUESTED;
    }

    /* We will not pass Driver in constructor, rider will only call this ride class
    * and driver isn't assigned yet*/

    public int getId() {
        return id;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public double getDistance() {
        return distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", rider=" + rider.getName() +
                ", driver=" + (driver != null ? driver.getName() : "Not Assigned") +
                ", distance=" + distance +
                ", status=" + status +
                '}';
    }
}
