package org.bb.manager;

import org.bb.entity.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderManager {
    private static RiderManager riderManagerInstance;
    private static final Object lock = new Object();
    private Map<String, Rider> ridersMap = new HashMap<>();

    private RiderManager(){}

    //Double-checked locking of Singleton.
    public static RiderManager getInstance(){
        if(riderManagerInstance == null){
            synchronized (lock){
                if(riderManagerInstance == null){
                    riderManagerInstance = new RiderManager();
                }
            }
        }
        return riderManagerInstance;
    }

    public void addRider(Rider rider){
        ridersMap.put(rider.getRiderId(), rider);
    }

}
