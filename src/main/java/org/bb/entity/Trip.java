package org.bb.entity;

import org.bb.strategy.DriverMatchingStrategy;
import org.bb.strategy.PricingStrategy;

public class Trip {

    private static int nextTripId = 0;
    private String tripId;
    private Rider rider;
    private Driver driver;
    private Location srcLocation;
    private Location dstLocation;
    private TRIP_STATUS tripStatus;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    public Trip(Rider rider, Driver driver, Location srcLocation, Location dstLocation, double price, PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.rider = rider;
        this.driver = driver;
        this.srcLocation = srcLocation;
        this.dstLocation = dstLocation;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.tripStatus = TRIP_STATUS.DRIVER_ON_THE_WAY;
        this.tripId = "TRIP_"+nextTripId;
        nextTripId++;
    }

    public String getTripId(){
        return tripId;
    }

    public void displayTripDetails() {
        System.out.println();
        System.out.println("Trip id - " + tripId);
        System.out.println("Rider - " + rider.getName()+" , "+rider.getRating());
        System.out.println("Driver - " + driver.getName()+" , "+driver.getRating());
        System.out.println("Price - " + price);
        System.out.println("Locations - " + srcLocation.getLatitude() + "," + srcLocation.getLongitude() +
                " to " + dstLocation.getLatitude() + "," + dstLocation.getLongitude());
    }
}
