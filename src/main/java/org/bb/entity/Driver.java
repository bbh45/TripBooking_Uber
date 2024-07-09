package org.bb.entity;

import java.util.UUID;

public class Driver {
    private final String driverId;
    private final String name;
    private boolean availability;
    private RATING rating;
    public Driver(String name, RATING rating){
        this.driverId = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.rating = rating;
        this.availability = true;
    }


    public String getDriverId() {
        return driverId;
    }

    public String getName() {
        return name;
    }

    public RATING getRating() {
        return rating;
    }

    public boolean getAvailability(){
        return availability;
    }

    public void setAvailability(Boolean availability){
        this.availability = availability;
    }
    public void updateAvailability(boolean availability) {
        this.availability = availability;
    }
}
