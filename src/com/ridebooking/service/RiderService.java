package com.ridebooking.service;

import com.ridebooking.exception.RiderNotFoundException;
import com.ridebooking.model.Rider;

import java.util.ArrayList;
import java.util.List;

public class RiderService {

    private final List<Rider> riders;

    public RiderService()
    {
        riders = new ArrayList<>();
    }

    public void registerRider(Rider rider)
    {
        riders.add(rider);
    }

    public Rider getRiderById(int riderId)
    {
        for (Rider rider: riders){
            if (rider.getId() == riderId)
                return rider;
        }

        throw new RiderNotFoundException("Rider not found with ID "+riderId);
    }
}
