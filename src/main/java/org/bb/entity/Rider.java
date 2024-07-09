package org.bb.entity;

import java.util.UUID;

public class Rider {

    private String riderId;
    private String name;
    private RATING rating;

    public Rider(String name, RATING rating){
        this.riderId = String.valueOf(UUID.randomUUID());
        this.name = name;
        this.rating = rating;
    }

    public String getName(){
        return name;
    }

    public RATING getRating(){
        return rating;
    }

    public String getRiderId(){
        return riderId;
    }
}
