package com.ridebooking.model;

public enum RideStatus {
    /*
    This will be the lifecycle of the Ride.
    Assigned -> Completed
    */

    REQUESTED,
    ASSIGNED,
    COMPLETED,
    CANCELLED
}
