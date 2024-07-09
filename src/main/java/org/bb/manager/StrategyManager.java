package org.bb.manager;

import org.bb.entity.TripMetaData;
import org.bb.strategy.*;

public class StrategyManager {
    private static StrategyManager strategyManagerInstance;
    public static final Object lock = new Object();

    private StrategyManager(){}

    public static StrategyManager getInstance(){
        if(strategyManagerInstance == null){
            synchronized (lock){
                if(strategyManagerInstance == null){
                    strategyManagerInstance = new StrategyManager();
                }
            }
        }
        return strategyManagerInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetaData tripMetaData){
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new RatingBasedPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetaData metaData) {
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}
