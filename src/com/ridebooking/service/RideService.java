package com.ridebooking.service;

import com.ridebooking.exception.NoDriverAvailableException;
import com.ridebooking.exception.RideNotFoundException;
import com.ridebooking.model.*;
import com.ridebooking.strategy.FareStrategy;
import com.ridebooking.strategy.RideMatchingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class RideService {

    private final List<Ride> rides;
    private final RiderService riderService;
    private final DriverService driverService;

    // Interfaces

    private final RideMatchingStrategy matchingStrategy;
    private final FareStrategy fareStrategy;




    public RideService(RiderService riderService,
                       DriverService driverService,
                       RideMatchingStrategy rideMatchingStrategy,
                       FareStrategy fareStrategy)
    {
        this.rides = new ArrayList<>();
        this.driverService = driverService;
        this.riderService = riderService;
        this.matchingStrategy = rideMatchingStrategy;
        this.fareStrategy = fareStrategy;
    }

    public FareReceipt requestRide(int rideId, int riderId, double distance)
    {
        Rider rider = riderService.getRiderById(riderId);

        List<Driver> availableDrivers = driverService.getAvailableDrivers();

        if (availableDrivers.isEmpty())
            throw new NoDriverAvailableException("No Drivers are currently available.");

        Driver driver = matchingStrategy.findDriver(rider, availableDrivers);

        if (driver == null)
        {
            throw new NoDriverAvailableException("No Driver could be assigned");
        }

        Ride ride = new Ride(rideId, rider, distance);
        ride.setDriver(driver);
        ride.setStatus(RideStatus.ASSIGNED);
        driver.setAvailable(false);
        rides.add(ride);

        double fare = fareStrategy.calculateFare(ride);

        return new FareReceipt(rideId, fare, LocalDateTime.now());
    }

    public void completeRide(int rideId)
    {
        Ride ride = getRideById(rideId);

        if (ride.getStatus() != RideStatus.ASSIGNED)
        {
            return;
        }
        ride.setStatus(RideStatus.COMPLETED);

        Driver driver = ride.getDriver();
        if (driver!=null)
        {
            driver.setAvailable(true);
        }
    }

    public Ride getRideById(int rideId)
    {
        for (Ride ride: rides)
        {
            if (ride.getId() == rideId)
                return ride;
        }
        throw new RideNotFoundException("Ride was not found with RideId "+rideId);
    }

    public List<Ride> getAllRides(){
        return rides;
    }
}
