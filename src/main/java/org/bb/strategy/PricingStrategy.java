package org.bb.strategy;

import org.bb.entity.TripMetaData;

public interface PricingStrategy {
    double calculatePrice(TripMetaData tripMetaData);
}
