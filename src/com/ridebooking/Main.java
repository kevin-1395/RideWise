package com.ridebooking;

import com.ridebooking.exception.NoDriverAvailableException;
import com.ridebooking.exception.RideNotFoundException;
import com.ridebooking.exception.RiderNotFoundException;
import com.ridebooking.model.*;
import com.ridebooking.service.DriverService;
import com.ridebooking.service.RideService;
import com.ridebooking.service.RiderService;
import com.ridebooking.strategy.DefaultFareStrategy;
import com.ridebooking.strategy.FareStrategy;
import com.ridebooking.strategy.NearestDriverStrategy;
import com.ridebooking.strategy.RideMatchingStrategy;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        RiderService riderService = new RiderService();
        DriverService driverService = new DriverService();

        RideMatchingStrategy matchingStrategy = new NearestDriverStrategy();
        FareStrategy fareStrategy = new DefaultFareStrategy();

        RideService rideService = new RideService(
                riderService, driverService, matchingStrategy, fareStrategy
        );

        while(true)
        {
            System.out.println("\n===== Ride Booking System =====");
            System.out.println("1. Register Rider");
            System.out.println("2. Register Driver");
            System.out.println("3. Show Available Drivers");
            System.out.println("4. Request Ride");
            System.out.println("5. Complete Ride");
            System.out.println("6. Show All Rides");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            try
            {
                switch (choice){
                    case 1:
                        registerRider(scanner, riderService);
                        break;
                    case 2:
                        registerDriver(driverService, scanner);
                        break;
                    case 3:
                        showAvailableDrivers(driverService);
                        break;
                    case 4:
                        requestRide(scanner, rideService);
                        break;
                    case 5:
                        completeRide(scanner, rideService);
                        break;
                    case 6:
                        showAllRides(rideService);
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid Choice");
                }
            } catch (RiderNotFoundException |
                     NoDriverAvailableException |
                     RideNotFoundException e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
    }

    public static void registerRider(Scanner scanner, RiderService riderService)
    {
        System.out.println("Enter Rider ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter rider name: ");
        String name = scanner.next();

        System.out.print("Enter rider location X: ");
        double x = scanner.nextDouble();

        System.out.print("Enter rider location Y: ");
        double y = scanner.nextDouble();

        Location location = new Location(x, y);

        Rider rider =
                new Rider(id, name, location);

        riderService.registerRider(rider);

        System.out.println("Rider registered successfully.");
    }

    public static void registerDriver(DriverService driverService, Scanner scanner)
    {
        System.out.print("Enter driver id: ");
        int id = scanner.nextInt();

        System.out.print("Enter driver name: ");
        String name = scanner.next();

        System.out.print("Enter driver location X: ");
        double x = scanner.nextDouble();

        System.out.print("Enter driver location Y: ");
        double y = scanner.nextDouble();

        System.out.print("Is driver available? (true/false): ");
        boolean available = scanner.nextBoolean();

        Location location = new Location(x, y);

        Driver driver = new Driver(id, name, location, available);

        driverService.registerDriver(driver);
        System.out.println("Driver registered successfully");
    }

    public static void showAvailableDrivers(DriverService driverService)
    {
        List<Driver> driverList = driverService.getAvailableDrivers();

        if(driverList.isEmpty())
        {
            System.out.println("No Drivers are currently available");

        }

        System.out.println("Available Drivers");

        for (Driver driver: driverList)
        {
            System.out.println(driver);

        }
    }

    private static void requestRide(Scanner scanner, RideService rideService)
    {
        System.out.print("Enter ride id: ");
        int rideId = scanner.nextInt();

        System.out.print("Enter rider id: ");
        int riderId = scanner.nextInt();

        System.out.print("Enter distance in km: ");
        double distance = scanner.nextDouble();

        FareReceipt fareReceipt = rideService.requestRide(rideId, riderId, distance);

        System.out.println("\n Ride assigned successfully");
    }

    public static void completeRide(Scanner scanner, RideService rideService)
    {
        System.out.print("Enter ride id: ");
        int rideId = scanner.nextInt();

        rideService.completeRide(rideId);

        System.out.println("Ride Completed Successfully");
    }

    public static void showAllRides(RideService rideService)
    {
        List<Ride> rides = rideService.getAllRides();

        if (rides.isEmpty())
        {
            System.out.println("No rides found");
        }

        for (Ride ride: rides){
            System.out.println(ride);
        }

    }
}
