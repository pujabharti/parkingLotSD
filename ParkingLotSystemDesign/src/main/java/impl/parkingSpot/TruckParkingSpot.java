package main.java.impl.parkingSpot;

import main.java.model.ParkingSpot;
import main.java.model.ParkingSpotType;
import main.java.model.Vehicle;
import main.java.model.VehicleType;

public class TruckParkingSpot implements ParkingSpot {
    private Vehicle currentVehicle;

    @Override
    public boolean isAvailable() {
        return currentVehicle == null;
    }

    @Override
    public void parkVehicle(Vehicle vehicle) {
        if (vehicle.getType() == VehicleType.TRUCK) {
            this.currentVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("Only trucks can park here.");
        }
    }

    @Override
    public void removeVehicle() {
        this.currentVehicle = null;
    }

    @Override
    public ParkingSpotType getSpotType() {
        return ParkingSpotType.TRUCK;
    }
}
