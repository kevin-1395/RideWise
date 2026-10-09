package com.ridebooking.strategy;

import com.ridebooking.model.Driver;
import com.ridebooking.model.Rider;

import java.util.List;

public interface RideMatchingStrategy {
    Driver findDriver (Rider rider, List<Driver> drivers);

    /* Return the Driver. Use Rider and Get list of available drivers
    This is just a contract to findDriver()

    ISP - Interface Segregation Principle */
}
