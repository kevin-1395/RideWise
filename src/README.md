Ride Booking System

A Core Java Low-Level Design (LLD) project demonstrating Object-Oriented Programming, SOLID principles, and the Strategy Design Pattern.

✅ Register riders and drivers

✅ View available drivers

✅ Request a ride

✅ Match riders with available drivers

✅ Calculate fares using pricing strategies

✅ Track ride statuses

✅ Complete rides and release drivers

✅ Generate fare receipts

✅ Handle errors using custom exceptions

Principle	Implementation

SRP	Each class has a focused responsibility.

OCP	New matching and fare strategies can be added through interfaces.

LSP	Strategy implementations can be substituted through their interfaces.

ISP	Separate interfaces define matching and fare calculation.

DIP	RideService depends on strategy abstractions instead of concrete strategy classes.