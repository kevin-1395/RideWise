package com.ridebooking.strategy;

import com.ridebooking.model.Ride;

public class PeakHourFareStrategy implements FareStrategy{

    private static final double BASE_FARE = 50.0;
    private static final double PER_KM_FARE = 10.0;
    private static final double PEAK_MULTIPLIER = 1.5;

    @Override
    public double calculateFare(Ride ride) {
        double normalFare = BASE_FARE + (ride.getDistance() * PER_KM_FARE);
        return normalFare * PEAK_MULTIPLIER;
    }
}
