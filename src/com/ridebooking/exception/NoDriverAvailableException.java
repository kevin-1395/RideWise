package com.ridebooking.exception;

public class NoDriverAvailableException extends RuntimeException{
    public NoDriverAvailableException(String message)
    {
        super(message);
    }

    /* This exception will be thrown when, no drivers are available for a requested Ride*/
}
