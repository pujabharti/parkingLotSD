package main.java.impl.vehicle;

import main.java.model.Vehicle;
import main.java.model.VehicleType;

public class Car implements Vehicle {
    private final String licensePlate;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }
}

