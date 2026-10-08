package com.ridebooking.strategy;

import com.ridebooking.model.Ride;

public interface FareStrategy {
    /* Contract to calculate fare for each ride  */
    double calculateFare(Ride ride);
}
