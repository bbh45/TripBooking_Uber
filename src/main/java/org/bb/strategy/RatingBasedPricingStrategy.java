package org.bb.strategy;

import org.bb.entity.TripMetaData;
import org.bb.utils.Util;

public class RatingBasedPricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(TripMetaData tripMetaData) {
        double price =  Util.isHighRating(tripMetaData.getRiderRating())? 55.0 : 60.0;
        System.out.println("Based on " + tripMetaData.getRiderRating().toString() +
                " rider rating, price of the trip is " + price);
        return price;
    }
}
