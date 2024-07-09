package org.bb.manager;

import org.bb.entity.*;
import org.bb.strategy.DriverMatchingStrategy;
import org.bb.strategy.PricingStrategy;

import java.util.HashMap;
import java.util.Map;

public class TripManager {
    private static TripManager tripManagerInstance;
    private static final Object lock = new Object();
    private RiderManager riderManager;
    private DriverManager driverManager;
    private Map<String, TripMetaData> tripsMetaDataInfo;
    private Map<String, Trip> tripsInfo;

    private TripManager(){
        riderManager = RiderManager.getInstance();
        driverManager = DriverManager.getInstance();
        tripsMetaDataInfo = new HashMap<>();
        tripsInfo = new HashMap<>();
    }

    public static TripManager getInstance(){
        if(tripManagerInstance == null){
            synchronized (lock){
                if(tripManagerInstance == null){
                    tripManagerInstance = new TripManager();
                }
            }
        }
        return tripManagerInstance;
    }

    public void createTrip(Rider rider, Location srcLocation, Location dstLocation){
        TripMetaData tripMetaData = new TripMetaData(srcLocation, dstLocation, rider.getRating());

        StrategyManager strategyManager = StrategyManager.getInstance();
        PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineMatchingStrategy(tripMetaData);

        Double price = pricingStrategy.calculatePrice(tripMetaData);
        Driver driver = driverMatchingStrategy.matchDriver(tripMetaData);

        if(driver == null){
            System.out.println("Trip is not created, Please try again.");
            return;
        }

        Trip trip = new Trip(rider,driver,srcLocation,dstLocation,price,pricingStrategy,driverMatchingStrategy);
        String tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, tripMetaData);
    }

    public Map<String, Trip> getTripsMap() {
        return tripsInfo;
    }


}
