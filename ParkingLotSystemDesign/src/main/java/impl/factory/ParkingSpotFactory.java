package main.java.impl.factory;

import main.java.impl.parkingSpot.BikeParkingSpot;
import main.java.impl.parkingSpot.CarParkingSpot;
import main.java.impl.parkingSpot.TruckParkingSpot;
import main.java.model.ParkingSpot;
import main.java.model.ParkingSpotType;

public class ParkingSpotFactory {
    public static ParkingSpot createParkingSpot(ParkingSpotType type) {
        switch (type) {
            case BIKE:
                return new BikeParkingSpot();
            case CAR:
                return new CarParkingSpot();
            case TRUCK:
                return new TruckParkingSpot();
            default:
                throw new IllegalArgumentException("Invalid Parking Spot Type");
        }
    }
}

