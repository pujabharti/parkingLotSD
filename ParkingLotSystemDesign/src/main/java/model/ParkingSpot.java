package main.java.model;

import main.java.model.ParkingSpotType;
import main.java.model.Vehicle;

public interface ParkingSpot {
    boolean isAvailable();
    void parkVehicle(Vehicle vehicle);
    void removeVehicle();
    ParkingSpotType getSpotType();
}
