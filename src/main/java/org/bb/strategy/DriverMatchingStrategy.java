package org.bb.strategy;

import org.bb.entity.TripMetaData;
import org.bb.entity.Driver;
import org.bb.manager.DriverManager;

public interface DriverMatchingStrategy {
    Driver matchDriver(TripMetaData tripMetaData);
}
