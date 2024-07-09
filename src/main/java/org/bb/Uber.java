package org.bb;

import org.bb.entity.*;
import org.bb.manager.DriverManager;
import org.bb.manager.RiderManager;
import org.bb.manager.TripManager;

import java.util.Map;

public class Uber {
    public static void main(String[] args) {

        Rider honeyRider = new Rider("Honey", RATING.FIVE_STARS);
        Rider giniRider = new Rider("Gini", RATING.THREE_STARS);
        Rider miniRider = new Rider("Mini", RATING.THREE_STARS);
        RiderManager riderManager = RiderManager.getInstance();
        riderManager.addRider(honeyRider);
        riderManager.addRider(giniRider);

        Driver ramuDriver = new Driver("Rama", RATING.THREE_STARS);
        Driver krishnaDriver = new Driver("Krishna", RATING.FIVE_STARS);
        DriverManager driverManager = DriverManager.getInstance();
        driverManager.addDriver(ramuDriver);
        driverManager.addDriver(krishnaDriver);

        TripManager tripManager = TripManager.getInstance();

        System.out.println("\nCreating Trip for Honey from location (10,10) to (30,30)");
        tripManager.createTrip(honeyRider, new Location(10, 10), new Location(30, 30));

        System.out.println("\nCreating Trip for Gini from location (200,200) to (500,500)");
        tripManager.createTrip(giniRider, new Location(200, 200), new Location(500, 500));

        System.out.println("\nCreating Trip for Mini from location (10,10) to (30,30)");
        tripManager.createTrip(miniRider, new Location(10, 10), new Location(30, 30));


//        Map<String, Driver> driverMap = driverManager.getDriversMap();
//        for (Map.Entry<String, Driver> entry : driverMap.entrySet()) {
//            System.out.println(entry.getKey() + "- " + entry.getValue().getName() +","+entry.getValue().getRating());
//        }

        Map<String, Trip> tripsMap = tripManager.getTripsMap();
        for (Map.Entry<String, Trip> entry : tripsMap.entrySet()) {
            entry.getValue().displayTripDetails();
        }
    }
}
