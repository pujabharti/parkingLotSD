package main.java.impl.vehicle;

import main.java.model.Vehicle;
import main.java.model.VehicleType;

public class Truck implements Vehicle {
    private String licensePlate;

    public Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }
}
