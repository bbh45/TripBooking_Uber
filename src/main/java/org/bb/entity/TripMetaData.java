package org.bb.entity;

import org.bb.entity.Location;
import org.bb.entity.RATING;

public class TripMetaData {
    private Location srcLocation;
    private Location destLocation;
    private RATING riderRATING;

    public TripMetaData(Location srcLocation, Location destLocation, RATING riderRATING){
        this.srcLocation = srcLocation;
        this.destLocation = destLocation;
        this.riderRATING = riderRATING;
    }

    public Location getSrcLocation() {
        return srcLocation;
    }

    public Location getDestLocation() {
        return destLocation;
    }

    public RATING getRiderRating() {
        return riderRATING;
    }

}
