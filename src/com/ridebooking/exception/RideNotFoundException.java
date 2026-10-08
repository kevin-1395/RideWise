package com.ridebooking.exception;

public class RideNotFoundException extends RuntimeException
{
    public RideNotFoundException(String message)
    {
        super(message);
    }

    /* When RideID is not found, RideService will be using it when cannot find
    * requested ride. */
}
