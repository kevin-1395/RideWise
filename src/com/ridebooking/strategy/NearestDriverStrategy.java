package com.ridebooking.strategy;

import com.ridebooking.model.Driver;
import com.ridebooking.model.Rider;

import java.util.List;

public class NearestDriverStrategy implements RideMatchingStrategy{

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers) {

        Driver nearestDriver = null;
        double minimumDistance = Double.MAX_VALUE;

        for (Driver driver: drivers)
        {
            double distance = rider.getLocation().distanceTo(driver.getCurrentLocation());

            if (distance < minimumDistance)
            {
                minimumDistance = distance;
                nearestDriver = driver;
            }
        }
        return nearestDriver;
    }
}
