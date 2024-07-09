package org.bb.manager;

import org.bb.entity.Driver;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverManager {
    public static DriverManager driverManagerInstance;
    public static final Object lock = new Object();
    private Map<String, Driver> driversMap = new HashMap<>();
    private DriverManager(){}

    public static DriverManager getInstance(){
        if(driverManagerInstance == null){
            synchronized (lock){
                if(driverManagerInstance == null){
                    driverManagerInstance = new DriverManager();
                }
            }
        }
        return driverManagerInstance;
    }

    public void addDriver(Driver driver){
        driversMap.put(driver.getDriverId(), driver);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }

    public Map<String, Driver> getAvailableDriversMap() {
        return driversMap
                .entrySet()
                .stream()
                .filter(x -> x.getValue().getAvailability())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    }
}

