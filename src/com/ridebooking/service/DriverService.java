package com.ridebooking.service;

import com.ridebooking.exception.DriverNotFoundException;
import com.ridebooking.model.Driver;

import java.util.ArrayList;
import java.util.List;

public class DriverService {

    private final List<Driver> drivers;

    public DriverService()
    {
        drivers = new ArrayList<>();
    }

    public void registerDriver(Driver driver)
    {
        drivers.add(driver);
    }

    public Driver getDriverById(int driverId)
    {
        for (Driver driver: drivers)
        {
            if (driver.getId() == driverId)
                return driver;
        }

        throw new DriverNotFoundException("Driver was not found with ID "+driverId);
    }

    public void updateAvailability(int driverId, boolean available)
    {
        Driver driver = getDriverById(driverId);
        driver.setAvailable(available);
    }

    public List<Driver> getAvailableDrivers()
    {
        List<Driver> availableDriver = new ArrayList<>();

        for (Driver driver: drivers)
        {
            if (driver.isAvailable())
                availableDriver.add(driver);

        }
        return availableDriver;
    }
}
