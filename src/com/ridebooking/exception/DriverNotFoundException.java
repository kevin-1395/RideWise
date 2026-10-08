package com.ridebooking.exception;

public class DriverNotFoundException extends RuntimeException{
    public DriverNotFoundException(String message)
    {
        super(message);
    }

    /* exception when Driver is not found */
}
