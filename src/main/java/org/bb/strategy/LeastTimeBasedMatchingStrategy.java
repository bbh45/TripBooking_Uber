package org.bb.strategy;

import org.bb.entity.TripMetaData;
import org.bb.entity.Driver;
import org.bb.manager.DriverManager;

import java.util.stream.Collectors;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(TripMetaData tripMetaData) {
        DriverManager driverManager = DriverManager.getInstance();

        if(driverManager.getAvailableDriversMap().isEmpty()){
            System.out.println("No drivers!");
            return null;
        }

        System.out.println("Using quadtree to see nearest cabs and using driver manager to get details of drivers and send notifications");
        Driver driver = driverManager.getAvailableDriversMap().entrySet().iterator().next().getValue();
        System.out.println("Setting " + driver.getName() + " as driver");
        driver.setAvailability(false);
        return driver;
    }
}
