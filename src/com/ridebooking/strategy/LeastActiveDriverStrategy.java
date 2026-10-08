package com.ridebooking.strategy;

import com.ridebooking.model.Driver;
import com.ridebooking.model.Rider;

import java.util.HashMap;
import java.util.List;

public class LeastActiveDriverStrategy implements RideMatchingStrategy{

    private HashMap<Integer, Integer> activeRideCount = new HashMap<>();

    @Override
    public Driver findDriver(Rider rider, List<Driver> drivers)
    {
        Driver selectedDriver = null;
        int minimumActiveRiders = Integer.MAX_VALUE;

        for (Driver driver: drivers)
        {
            int count = activeRideCount.getOrDefault(driver.getId(), 0);

            if (count < minimumActiveRiders)
            {
                minimumActiveRiders = count;
                selectedDriver = driver;
            }
        }

        if (selectedDriver != null)
        {
            activeRideCount.put(selectedDriver.getId(), minimumActiveRiders + 1);
        }
    return selectedDriver;
    }
}
